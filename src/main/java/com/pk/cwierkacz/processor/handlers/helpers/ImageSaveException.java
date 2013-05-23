package com.pk.cwierkacz.processor.handlers.helpers;

public class ImageSaveException extends Exception
{
    private static final long serialVersionUID = -433373860710064484L;

    public ImageSaveException() {
        super("Exception while saving image");
    }
}
