package com.pk.cwierkacz.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.pk.cwierkacz.exception.StartException;

public class PropertyReaderTest
{

    private PropertyReader propertyReader;

    @Before
    public void setUp( ) throws StartException {
        propertyReader = new PropertyReader();
        propertyReader.start();
    }

    @Test
    public void readPropertNonExistTest( ) {

        Assert.assertEquals("TestVal", propertyReader.getProperty("Test", "TestVal"));
    }

    @Test
    public void readPropertTest( ) {

        Assert.assertEquals("testFileVal", propertyReader.getProperty("testFile", "TestVal"));
    }
}
