package com.tguzik.cwierkacz.twitter.attachment;

import java.io.File;

/**
 * Represents a Image which we add to Tweet
 * 
 */
public class ImageAttachment extends TweetAttachment<File>
{

    public ImageAttachment( File attachment ) {
        super(attachment);
    }
}
