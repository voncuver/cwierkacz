package com.pk.cwierkacz.twitter;

import com.pk.cwierkacz.model.dao.TweetDao;

/**
 * 
 * @author radek
 * 
 *         this interface must implement by DB API in order to twitter acount
 *         listener can add/remove tweets
 */
interface TwitterStorage
{
    /**
     * Add tweet to DB, this simple method is same if tweet is reply or reTweet.
     * Tweet may exist in DB before! Ignore this situation
     * 
     * @param tweet
     */
    public void addUnclassifiedTweet( TweetDao tweet );

    /**
     * Mark tweet as deleted. Tweet may be marked before. Ignore this situation
     * 
     * @param tweetId
     */
    public void removeTweet( long tweetId );
}
