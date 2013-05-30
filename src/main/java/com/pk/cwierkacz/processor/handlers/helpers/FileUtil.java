package com.pk.cwierkacz.processor.handlers.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.pk.cwierkacz.model.dao.SettingsDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;
import com.pk.cwierkacz.twitter.attachment.ImageAttachment;
import com.pk.cwierkacz.twitter.attachment.TweetAttachments;

public class FileUtil
{
    public final SettingsService settingsService = ServiceRepo.getInstance()
                                                              .getService(SettingsService.class);

    public String trimPath( String path ) {
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

    protected FileData createFileData( File file, byte[] bytes ) {
        SettingsDao imgSettings = settingsService.getImageSettings();
        String sl = "";
        if ( !imgSettings.getRelativeImgPath().endsWith(File.separator) )
            sl = File.separator;
        String filepath = imgSettings.getRelativeImgPath() + sl + file.getName();

        return createFileData(file, bytes, filepath);

        //TODO DOS ATTACK DENGER - control of size image and number of trying add image per user - probably these controls not in here, but somewhere higher

    }

    protected FileData createFileData( File file, byte[] bytes, String filepath ) {
        ImageAttachment image = new ImageAttachment(file);
        TweetAttachments attachments = TweetAttachments.createImage(image);

        FileData resp = new FileData();
        resp.setImgPath(filepath);
        resp.setImgName(file.getName());
        resp.setBytes(bytes);
        resp.setAttachments(attachments);
        return resp;

        //TODO DOS ATTACK DENGER - control of size image and number of trying add image per user - probably these controls not in here, but somewhere higher

    }

    public FileData saveFile( byte[] fileBytes, String fileName ) throws IOException {
        File file = createFile(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        IOUtils.write(fileBytes, fos);
        fos.close();
        return createFileData(file, fileBytes);

    }

    public FileData saveFileFromUrl( String urlPath ) throws IOException {
        if ( urlPath == null )
            return null;
        else {
            URL url = new URL(urlPath);
            byte[] bytes = IOUtils.toByteArray(url);
            return saveFile(bytes, trimPath(urlPath));

        }
    }

    public FileData readFile( String imgPath ) throws IOException {
        if ( imgPath == null )
            return null;
        else {
            SettingsDao containerSettings = settingsService.getContainerSettings();
            String absoluteContainerPath = containerSettings.getAbsoluteContainerPath();
            if ( !absoluteContainerPath.endsWith(File.separator) ) {
                absoluteContainerPath += File.separator;
            }
            File file = new File(absoluteContainerPath + imgPath);
            FileInputStream fin = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(fin);
            fin.close();
            return createFileData(file, bytes, imgPath);

        }
    }
}
