package com.tguzik.cwierkacz.cache.dataobject;

import java.util.ArrayList;
import java.util.List;

import com.tguzik.cwierkacz.cache.UniqueKey;
import com.tguzik.cwierkacz.utils.annotation.Immutable;
import com.tguzik.cwierkacz.utils.annotation.ReflectionInstanitation;

@Immutable
@ReflectionInstanitation
public final class Tweets extends DataObject
{

    private final List<Tweet> tweets;

    @Override
    public UniqueKey getUniqueKey( ) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * create instance of Tweets with empty list of tweets
     */
    public Tweets() {
        this.tweets = new ArrayList<Tweet>();
    }

    /**
     * create instance of Tweets
     * 
     * @param tweets
     *            a list of single tweets
     */
    public Tweets( List<Tweet> tweets ) {
        this.tweets = tweets;
    }

    /**
     * returns a list of tweet
     */
    public List<Tweet> getTweets( ) {
        return tweets;
    }

    /**
     * Add a single tweet
     * 
     * @param tweet
     */
    public void addTweet( Tweet tweet ) {
        tweets.add(tweet);
    }

    /**
     * Add collection of tweets
     * 
     * @param newTweets
     */
    public void addTweets( List<Tweet> newTweets ) {
        tweets.addAll(newTweets);
    }

    /**
     * Add collection of tweets
     * 
     * @param newTweets
     */
    public void addTweets( Tweets newTweets ) {
        tweets.addAll(newTweets.getTweets());
    }
}
