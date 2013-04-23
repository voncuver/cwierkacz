package com.pk.cwierkacz.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashUtil
{
    private static Logger logger = LoggerFactory.getLogger(HashUtil.class);

    public static String hashString( String string ) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch ( NoSuchAlgorithmException e ) {
            e.printStackTrace();
            return "";
        }
        md.update(string.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < byteData.length; i++ ) {
            sb.append(Integer.toString(( byteData[ i ] & 0xff ) + 0x100, 16).substring(1));
        }
        logger.debug(string + " " + sb.toString());
        return sb.toString();
    }
}
