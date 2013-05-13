package com.pk.cwierkacz.processor.handlers;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.http.Action;
import com.pk.cwierkacz.http.Status;
import com.pk.cwierkacz.http.request.PublishRequest;
import com.pk.cwierkacz.http.response.Response;
import com.pk.cwierkacz.http.response.ResponseImpl;
import com.pk.cwierkacz.model.ApplicationData;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;
import com.pk.cwierkacz.model.service.TweetService;
import com.pk.cwierkacz.model.service.TwitterAccountService;
import com.pk.cwierkacz.processor.handlers.helpers.AccountPermissionValidator;
import com.pk.cwierkacz.processor.handlers.helpers.AttachmentsWithResources;
import com.pk.cwierkacz.processor.handlers.helpers.FileSaver;
import com.pk.cwierkacz.twitter.TwitterAccount;
import com.pk.cwierkacz.twitter.TwitterAccountMap;
import com.pk.cwierkacz.twitter.TwitterActionException;
import com.pk.cwierkacz.twitter.TwitterAuthenticationException;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class PublishTweetAccount extends AbstractHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PublishTweetAccount.class);

    private final TweetService tweetService;

    private final TwitterAccountService accountService;
    private final SettingsService settingsService;
    private final FileSaver fileSaver;

    public PublishTweetAccount() {
        this.tweetService = ServiceRepo.getInstance().getService(TweetService.class);
        this.accountService = ServiceRepo.getInstance().getService(TwitterAccountService.class);
        this.settingsService = ServiceRepo.getInstance().getService(SettingsService.class);
        this.fileSaver = new FileSaver();
    }

    @Override
    public boolean isHandleable( ApplicationData applicationData ) {
        return applicationData.getRequest().getAction().equals(Action.PUBLISHTWEET);
    }

    @Override
    public void handle( ApplicationData appData ) {
        PublishRequest publishRequest = (PublishRequest) appData.getRequest();

        boolean errors = false;
        boolean deny = false;
        StringBuilder errorBuilder = new StringBuilder();

        if ( !AccountPermissionValidator.checkPermissionForName(publishRequest.getAccounts(),
                                                                publishRequest.getTokenId()) ) {
            errorBuilder.append("you do not have rights to at least one account; ");
            deny = true;
        }

        TweetDao inReply = null;
        TweetDao retweeted = null;
        if ( publishRequest.getReplayFor() > 0 )
            inReply = tweetService.getTweetById(publishRequest.getReplayFor());
        if ( publishRequest.getRetweetFor() > 0 )
            retweeted = tweetService.getTweetById(publishRequest.getRetweetFor());
        if ( publishRequest.getRetweetFor() <= 0 && publishRequest.getTweetText() == null ) {
            errorBuilder.append("new tweet must have content; ");
            errors = true;
        }

        if ( publishRequest.getRetweetFor() > 0 &&
             ( publishRequest.getReplayFor() > 0 || !StringUtils.isEmpty(publishRequest.getTweetText()) || publishRequest.getBody() != null ) ) {
            errorBuilder.append("retweet can't be reply and retweet cant't have own text or image; ");
            errors = true;
        }
        if ( publishRequest.getReplayFor() > 0 && inReply == null ) {
            errorBuilder.append("in reply tweet not exist ; ");
            errors = true;
        }
        if ( publishRequest.getRetweetFor() > 0 && retweeted == null ) {
            errorBuilder.append("retweeted tweet not exist ; ");
            errors = true;
        }
        if ( publishRequest.getBody() != null &&
             publishRequest.getImgName() == null ||
             publishRequest.getBody() == null &&
             publishRequest.getImgName() != null ) {
            errorBuilder.append("if request contain image then request also must contain image name and vice versa ; ");
            errors = true;
        }
        String filename = null;
        TweetAttachments attachments = TweetAttachments.empty();
        if ( !errors && !deny && publishRequest.getBody() != null && publishRequest.getImgName() != null ) {
            try {
                AttachmentsWithResources awr = fileSaver.saveFile(publishRequest.getBody(),
                                                                  publishRequest.getImgName());
                filename = awr.getImgPath();
                attachments = awr.getAttachments();
            }
            catch ( IOException e ) {
                LOGGER.error(e.getMessage());
                errorBuilder.append("cannot save image ; ");
                errors = true;
            }

        }

        if ( !errors && !deny ) {
            for ( String accountName : publishRequest.getAccounts() ) {
                try {
                    //tranzakcyjność per jedno konto - a może inaczej?
                    TwitterAccountDao accountDao = accountService.getAccountByName(accountName);
                    if ( accountDao == null ) {
                        errorBuilder.append(accountName + " not exist in system ; ");
                    }
                    else {
                        TweetDao newTweet = null;
                        TwitterAccount account = TwitterAccountMap.getTwitterAccount(accountDao);
                        if ( inReply != null ) {
                            newTweet = account.composeNewReplyTweet(publishRequest.getTweetText(),
                                                                    inReply,
                                                                    attachments);
                        }
                        else if ( retweeted != null ) {
                            newTweet = account.composeNewReTweet(retweeted);
                            newTweet.setImagePath(retweeted.getImagePath());
                        }
                        else {
                            newTweet = account.composeNewTweet(publishRequest.getTweetText(), attachments);
                        }
                        newTweet.setCreator(accountDao);
                        if ( filename != null )
                            newTweet.setImagePath(filename);

                        tweetService.save(newTweet);

                    }
                }
                catch ( TwitterAuthenticationException e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("fail while authenticate for " + accountName + " ; ");
                }
                catch ( TwitterActionException e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("fail while add tweet for " + accountName + " ; ");
                }
                catch ( Throwable e ) {
                    LOGGER.error(e.getMessage());
                    errorBuilder.append("internal error for " + accountName + " ; ");
                }
            }
        }

        Response response;
        String errorsMsg = errorBuilder.toString();

        if ( errors ) {
            response = ResponseImpl.create(Status.ERROR, "Tweet for not all account was add correctly - " +
                                                         errorsMsg, appData.getRequest().getTokenId());
        }
        else if ( deny ) {
            response = ResponseImpl.create(Status.DENY, "Deny access - " + errorsMsg, appData.getRequest()
                                                                                             .getTokenId());
        }
        else {
            response = ResponseImpl.create(Status.OK,
                                           "Tweet for all account was add correctly",
                                           appData.getRequest().getTokenId());
        }
        appData.setResponse(response);
    }
}
