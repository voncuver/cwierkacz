package com.pk.cwierkacz.twitter.attachment;

import java.util.ArrayList;
import java.util.List;

/**
 * List of attachment which we add to file
 * 
 */
public class TweetAttachments
{
    private final ImageAttachment image;

    public TweetAttachments( ImageAttachment image ) {
        this.image = image;
    }

    @SuppressWarnings( "rawtypes" )
    public List<TweetAttachment> attachments( ) {
        List<TweetAttachment> attachments = new ArrayList<TweetAttachment>();
        if ( haveImage() )
            attachments.add(image);

        return attachments;
    }

    public ImageAttachment getImage( ) {
        return image;
    }

    public static TweetAttachments createImage( ImageAttachment attachment ) {
        return new TweetAttachments(attachment);
    }

    public static TweetAttachments empty( ) {
        return new TweetAttachments(null);
    }

    public boolean haveImage( ) {
        if ( image != null && image.isDefined() )
            return true;
        else
            return false;
    }

}
