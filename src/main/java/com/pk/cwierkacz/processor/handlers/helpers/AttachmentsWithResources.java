package com.pk.cwierkacz.processor.handlers.helpers;

import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class AttachmentsWithResources
{
    private String imgPath;

    private TweetAttachments attachments = TweetAttachments.empty();

    public AttachmentsWithResources( String imgPath ) {
        this.imgPath = imgPath;
    }

    public TweetAttachments getAttachments( ) {
        return attachments;
    }

    public void setAttachments( TweetAttachments attachments ) {
        this.attachments = attachments;
    }

    public void setAttachments( ImageAttachment attachment ) {
        this.attachments = TweetAttachments.createImage(attachment);
    }

    public String getImgPath( ) {
        return imgPath;
    }

    public void setImgPath( String imgPath ) {
        this.imgPath = imgPath;
    }
}
