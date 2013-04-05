package com.tguzik.cwierkacz.twitter;

import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_AVAILABLE_API_CALLS;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_DESTROY_STATUS;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_GET_TIMELINE;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_POST_STATUS;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_SEARCH_QUERY;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_SEARCH_RESULT;
import static com.tguzik.cwierkacz.common.data.artifacts.ArtifactType.TWITTER_SEND_DIRECT_MESSAGE;
import static java.lang.String.format;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.google.common.collect.ImmutableList;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.cache.dataobject.Tweet;
import com.tguzik.cwierkacz.common.data.artifacts.ArtifactType;
import com.tguzik.cwierkacz.common.data.artifacts.ArtifactsHistory;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountName;
import com.tguzik.cwierkacz.common.data.value.TweetId;
import com.tguzik.cwierkacz.twitter.converters.TweetConverter;

public class TwitterFacade
{
    private static final TweetConverter CONVERTER = new TweetConverter();
    private static final TwitterFactory FACTORY = new TwitterFactory();
    private final ArtifactsHistory artifacts;
    private final FunctionalAccount account;
    private final Twitter connector;

    private TwitterFacade( Twitter connector, FunctionalAccount account, ArtifactsHistory artifacts ) {
        this.artifacts = artifacts;
        this.connector = connector;
        this.account = account;
    }

    public void post( Tweet tweet ) throws TwitterException {
        addArtifact(TWITTER_POST_STATUS, tweet);
        connector.updateStatus(CONVERTER.fromTweet(tweet));
    }

    public void sendDirectMessage( FunctionalAccountName name, String text ) throws TwitterException {
        addArtifact(TWITTER_SEND_DIRECT_MESSAGE, format("%s -> '%s'", name.toString(), text));
        connector.sendDirectMessage(name.toValue(), text);
    }

    public ImmutableList<Tweet> search( Query query ) throws TwitterException {
        addArtifact(TWITTER_SEARCH_QUERY, query);

        QueryResult result = connector.search(query);

        addArtifact(TWITTER_SEARCH_RESULT,
                    format("msgs: %s, since: %s, maxid: %s",
                           result.getCount(),
                           result.getSinceId(),
                           result.getMaxId()));

        return CONVERTER.fromResults(result);
    }

    public ImmutableList<Tweet> getHomeTimeline( Tweet since ) throws TwitterException {
        Paging paging = new Paging(since.getTweetId().toValue());

        addArtifact(TWITTER_GET_TIMELINE, paging);

        ResponseList<Status> response = connector.getHomeTimeline(paging);
        RateLimitStatus rateLimit = response.getRateLimitStatus();

        addArtifact(TWITTER_AVAILABLE_API_CALLS,
                    format("remaining: %s, secondsuntilreset: %s",
                           rateLimit.getRemaining(),
                           rateLimit.getSecondsUntilReset()));

        return CONVERTER.toTweets(response);
    }

    public void destroyStatus( TweetId id ) throws TwitterException {
        addArtifact(TWITTER_DESTROY_STATUS, id);
        connector.destroyStatus(id.toValue());
    }

    private void addArtifact( ArtifactType type, Object message ) {
        this.artifacts.add(account, type, message);
    }

    public static TwitterFacade forAccount( FunctionalAccount account, ArtifactsHistory artifacts ) throws TwitterAuthenticationException {
        return new TwitterFacade(authenticate(account), account, artifacts);
    }

    private static Twitter authenticate( FunctionalAccount account ) throws TwitterAuthenticationException {
        if ( account.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            return FACTORY.getInstance(token);
        }

        throw new TwitterAuthenticationException("oAuth authentication impossible");
    }

}
