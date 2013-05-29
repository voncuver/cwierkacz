package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageSaver
{

    private final FileSaver fileSaver = new FileSaver();

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageSaver.class);

    public AttachmentsWithResources saveImage( byte[] image, String imgName, String imgURL ) throws ImageSaveException {

        try {
            if ( image != null && imgName != null ) {
                return fileSaver.saveFile(image, imgName);
            }
            else if ( imgURL != null ) {
                return fileSaver.saveFileFromUrl(imgURL);
            }
            else
                return null;
        }
        catch ( IOException e ) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw new ImageSaveException();
        }
    }
}
