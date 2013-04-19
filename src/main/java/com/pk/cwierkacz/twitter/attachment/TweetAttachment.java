package com.pk.cwierkacz.twitter.attachment;

/**
 * Attachment which we can add to tweet: f.ex. picture or geo location etc.
 * 
 */
public abstract class TweetAttachment< T >
{
    public TweetAttachment( T attachment ) {
        this.attachment = attachment;
    }

    private final T attachment;

    public T getAttachment( ) {
        return attachment;
    }

    public boolean isDefined( ) {
        if ( attachment == null )
            return false;
        else
            return true;
    }
}
