package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.model.dao.SettingsDao;
import com.pk.cwierkacz.model.dao.TweetDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;

public class ImageUtil
{

    private final FileUtil fileSaver = new FileUtil();

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUtil.class);

    public final SettingsService settingsService = ServiceRepo.getInstance()
                                                              .getService(SettingsService.class);

    public FileData saveImage( byte[] image, String imgName, String imgURL ) throws ImageSaveException {

        try {
            if ( image != null && imgName != null ) {
                return fileSaver.saveFile(image, imgName);
            }
            else if ( imgURL != null ) {
                return fileSaver.saveFileFromUrl(imgURL);
            }
            else
                return new FileData();
        }
        catch ( IOException e ) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw new ImageSaveException();
        }
    }

    public FileData readImage( String imgPath ) throws ImageSaveException {

        try {
            if ( imgPath != null ) {
                return fileSaver.readFile(imgPath);
            }
            else
                return new FileData();
        }
        catch ( IOException e ) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw new ImageSaveException();
        }
    }

    public FileData readDefaultImage( ) throws ImageSaveException {
        SettingsDao imageSettings = settingsService.getDefaultImage();
        if ( imageSettings != null ) {
            try {
                return fileSaver.readFileFromUrl(imageSettings.getDefaultImgUrl(),
                                                 imageSettings.getDefaultImgName());
            }
            catch ( IOException e ) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
                throw new ImageSaveException();
            }
        }
        else
            return new FileData();
    }

    public TweetDao tweetWithImg( TweetDao t ) throws IOException {
        FileData awr = fileSaver.saveFileFromUrl(t.getTwitterImageUrl());
        if ( awr != null )
            t.setImagePath(awr.getImgPath());
        return t;
    }
}
