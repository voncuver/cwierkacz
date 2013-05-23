package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageSaver
{

    private final FileSaver fileSaver = new FileSaver();

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageSaver.class);

    public AttachmentsWithResources saveImage( byte[] image, String imgName, String imgURL ) throws ImageSaveException {
        if ( image != null && imgName != null ) {
            return saveImage(image, imgName);
        }
        else if ( imgURL != null ) {
            return saveImage(imgURL);
        }
        else
            return null;
    }

    public AttachmentsWithResources saveImage( String imgURL ) {
        return null; //TODO
    }

    public AttachmentsWithResources saveImage( byte[] image, String imgName ) throws ImageSaveException {
        try {
            AttachmentsWithResources awr = fileSaver.saveFile(image, imgName);
            return awr;
        }
        catch ( IOException e ) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw new ImageSaveException();
        }

    }
}
