package com.tguzik.cwierkacz.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.common.data.value.TweetId;
import com.tguzik.cwierkacz.twitter.converters.TweetConverter;

public class TwitterFacade
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterFacade.class);
    private static final TweetConverter CONVERTER = new TweetConverter();
    private static final TwitterFactory FACTORY = new TwitterFactory();
    private final Twitter connector;

    private TwitterFacade( Twitter connector ) {
        this.connector = connector;
    }

    public void post( Tweet tweet ) throws TwitterException {
        connector.updateStatus(CONVERTER.fromTweet(tweet));
    }

    public ImmutableList<Tweet> searchForReplies( Tweet tweet ) throws TwitterException {
        return searchForReplies(tweet.getTweetId());
    }

    public ImmutableList<Tweet> searchForReplies( TweetId statusId ) throws TwitterException {
        return search((Query) null); // FIXME
    }

    public ImmutableList<Tweet> search( Query query ) throws TwitterException {
        QueryResult result = connector.search(query);
        return CONVERTER.fromResults(result);
    }

    public void destroyStatus( TweetId id ) throws TwitterException {
        connector.destroyStatus(id.toValue());
    }

    public static TwitterFacade forAccount( FunctionalAccount account ) throws TwitterAuthenticationException {
        return new TwitterFacade(authenticate(account));
    }

    private static Twitter authenticate( FunctionalAccount account ) throws TwitterAuthenticationException {
        if ( account.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            return FACTORY.getInstance(token);
        }

        throw new TwitterAuthenticationException("oAuth authentication impossible");
    }

}
