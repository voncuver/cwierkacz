package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.pk.cwierkacz.model.dao.SettingsDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;
import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class FileSaver
{
    public final SettingsService settingsService = ServiceRepo.getInstance()
                                                              .getService(SettingsService.class);

    protected String trimPath( String path ) {
        int index = path.lastIndexOf('/');
        if ( index < 0 )
            return path;
        else
            return path.substring(index + 1);
    }

    protected File createFile( String sufix ) throws IOException {
        File dir = new File(settingsService.getImageAbsolutePath());
        if ( !dir.exists() )
            dir.mkdir();
        File file = File.createTempFile("img_", "_" + sufix, dir);
        return file;
    }

    protected AttachmentsWithResources createTweetWithAttachments( File file ) {
        SettingsDao imgSettings = settingsService.getImageSettings();
        String sl = "";
        if ( !imgSettings.getRelativeImgPath().endsWith(File.separator) )
            sl = File.separator;
        String filename = imgSettings.getRelativeImgPath() + sl + file.getName();
        ImageAttachment image = new ImageAttachment(file);
        TweetAttachments attachments = TweetAttachments.createImage(image);

        AttachmentsWithResources resp = new AttachmentsWithResources(filename);
        resp.setAttachments(attachments);
        return resp;

        //TODO DOS ATTACK DENGER - control of size image and number of trying add image per user - probably these controls not in here, but somewhere higher

    }

    public AttachmentsWithResources saveFile( byte[] fileByte, String fileName ) throws IOException {
        File file = createFile(fileName);
        IOUtils.write(fileByte, new FileOutputStream(file));
        return createTweetWithAttachments(file);

    }

    public AttachmentsWithResources saveFileFromUrl( String urlPath ) throws IOException {
        if ( urlPath == null )
            return null;
        else {
            URL url = new URL(urlPath);
            File file = createFile(trimPath(urlPath));
            IOUtils.copy(url.openStream(), new FileOutputStream(file));
            AttachmentsWithResources ars = createTweetWithAttachments(file);
            return ars;

        }
    }
}
