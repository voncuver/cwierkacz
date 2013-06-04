package com.pk.cwierkacz.processor.handlers.helpers;

import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class FileData
{
    private String imgPath;

    private String imgName;

    private byte[] bytes;

    private TweetAttachments attachments = TweetAttachments.empty();

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

    public String getImgName( ) {
        return imgName;
    }

    public void setImgName( String imgName ) {
        this.imgName = imgName;
    }

    public byte[] getBytes( ) {
        return bytes != null ? bytes : new byte[0];
    }

    public void setBytes( byte[] bytes ) {
        this.bytes = bytes;
    }

    public boolean isEmpty( ) {
        return imgPath == null && imgName == null && bytes == null;
    }
}
