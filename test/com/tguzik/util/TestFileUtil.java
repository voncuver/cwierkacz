package com.tguzik.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class TestFileUtil
{
    public static String getFileContents( String path, String fileName ) throws FileNotFoundException,
                                                                        IOException {
        return IOUtils.toString(Files.newInputStream(Paths.get(getManipulatedPackageName(), path, fileName)));
    }

    private static String getManipulatedPackageName( ) {
        return "test/" + TestFileUtil.class.getPackage().getName().replace(".", "/");
    }

    public static InputStream getFileContentsAsInputStream( String path, String fileName ) throws FileNotFoundException,
                                                                                          IOException {
        return stringToInputStream(getFileContents(path, fileName));
    }

    public static InputStream stringToInputStream( String str ) {
        return IOUtils.toInputStream(str);
    }

    public static String normalizeLineEndings( String fileContents ) {
        return fileContents.replaceAll("(\r)?\n(\r)?", "\n");
    }

    @Test
    public void sanityTest_opensFile( ) throws FileNotFoundException, IOException {
        assertEquals("test", getFileContents(".", "testfile.txt"));
    }
}
