package com.pk.cwierkacz.twitter;

import com.google.common.collect.ImmutableList;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.twitter.converters.ToTweetConverter;

/**
 * Tweeter results of tweeter home timeline
 * 
 * @author radek
 * 
 */
public class TweetsResult
{
    private static final ToTweetConverter CONVERTER = new ToTweetConverter();

    /**
     * if false that mens that result is not full. Probably we get all tweets
     * from home timeline or twitter result is too big, so twitter don't return
     * all values
     */
    private final boolean fullResult;

    /**
     * Tweets already exist ing DB
     */
    private final ImmutableList<TweetDao> existingTweets;

    /**
     * Tweets which we can store in db in this moment
     */
    private final ImmutableList<TweetDao> readyTweets;

    /**
     * Tweets which we can't store in fb in this moment - f. ex. reference
     * retweetId is not store yet
     */
    private final ImmutableList<TweetDao> notReadyTweets;

    public boolean allReady( ) {
        return ( readyTweets.size() == 0 );
    }

    public int size( ) {
        return getTweets().size();
    }

    private boolean notReady( TweetDao t ) {
        return ( ( t.getInReplyTo() == null && t.getInReplyToExtId() != null ) || ( t.getRetweeted() == null && t.getRetweetedExtId() != null ) );
    }

    public TweetsResult() {
        this.fullResult = true;
        this.existingTweets = ImmutableList.of();
        this.readyTweets = ImmutableList.of();
        this.notReadyTweets = ImmutableList.of();
    }

    public TweetsResult( boolean fullResult,
                         ImmutableList<TweetDao> existingTweets,
                         ImmutableList<TweetDao> readyTweets,
                         ImmutableList<TweetDao> notReadyTweets ) {
        this.fullResult = fullResult;
        this.existingTweets = existingTweets;
        this.readyTweets = readyTweets;
        this.notReadyTweets = notReadyTweets;
    }

    public TweetsResult( boolean fullResult, ImmutableList<TweetDao> tweets ) {
        this.fullResult = fullResult;
        ImmutableList.Builder<TweetDao> existingTweetsB = ImmutableList.builder();
        ImmutableList.Builder<TweetDao> readyTweetsB = ImmutableList.builder();
        ImmutableList.Builder<TweetDao> notReadyTweetsB = ImmutableList.builder();
        for ( int i = 0; i < tweets.size(); i++ ) {
            TweetDao t = tweets.get(i);
            if ( t.getId() != null )
                existingTweetsB.add(t);
            else if ( notReady(t) )
                notReadyTweetsB.add(t);
            else
                readyTweetsB.add(t);
        }
        existingTweets = existingTweetsB.build();
        readyTweets = readyTweetsB.build();
        notReadyTweets = notReadyTweetsB.build();

    }

    public static TweetsResult full( ImmutableList<TweetDao> tweets ) {
        return new TweetsResult(true, tweets);
    }

    public static TweetsResult partially( ImmutableList<TweetDao> tweets ) {
        return new TweetsResult(false, tweets);
    }

    public boolean isFullResult( ) {
        return fullResult;
    }

    public ImmutableList<TweetDao> getTweets( ) {
        ImmutableList.Builder<TweetDao> builder = ImmutableList.builder();
        builder.addAll(existingTweets);
        builder.addAll(readyTweets);
        builder.addAll(notReadyTweets);

        return builder.build();
    }

    public ImmutableList<TweetDao> getExistingTweets( ) {
        return existingTweets;
    }

    public ImmutableList<TweetDao> getReadyTweets( ) {
        return readyTweets;
    }

    public ImmutableList<TweetDao> getNotReadyTweets( ) {
        return notReadyTweets;
    }

    public TweetsResult fulfilledNoReady( TwitterAccount twitterAccount ) throws TwitterActionException {
        ImmutableList.Builder<TweetDao> allTweets = ImmutableList.builder();
        for ( int i = 0; i < notReadyTweets.size(); i++ ) {
            TweetDao t = CONVERTER.fulfill(notReadyTweets.get(i));
            allTweets.add(t);
            if ( notReady(t) ) {

                if ( t.getRetweetedExtId() != null ) {
                    TweetDao newT = twitterAccount.getTweet(t.getRetweetedExtId());
                    allTweets.add(newT);
                }
                if ( t.getInReplyToExtId() != null ) {
                    TweetDao newT = twitterAccount.getTweet(t.getInReplyToExtId());
                    allTweets.add(newT);
                }
            }
        }
        return new TweetsResult(fullResult, allTweets.build());
    }

    public TweetsResult add( TweetsResult in ) {
        ImmutableList.Builder<TweetDao> existingTweetsB = ImmutableList.builder();
        ImmutableList.Builder<TweetDao> readyTweetsB = ImmutableList.builder();
        ImmutableList.Builder<TweetDao> notReadyTweetsB = ImmutableList.builder();

        existingTweetsB.addAll(existingTweets);
        readyTweetsB.addAll(readyTweets);
        notReadyTweetsB.addAll(notReadyTweets);

        for ( int i = 0; i < in.existingTweets.size(); i++ ) {
            TweetDao t = in.existingTweets.get(i);
            if ( !existingTweets.contains(t) )
                existingTweetsB.add(t);
        }

        for ( int i = 0; i < in.readyTweets.size(); i++ ) {
            TweetDao t = in.readyTweets.get(i);
            if ( !readyTweets.contains(t) )
                readyTweetsB.add(t);
        }

        for ( int i = 0; i < in.notReadyTweets.size(); i++ ) {
            TweetDao t = in.notReadyTweets.get(i);
            if ( !notReadyTweets.contains(t) )
                notReadyTweetsB.add(t);
        }

        return new TweetsResult(in.fullResult && fullResult,
                                existingTweetsB.build(),
                                readyTweetsB.build(),
                                notReadyTweetsB.build());
    }

}
