package com.pk.cwierkacz.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pk.cwierkacz.Startable;
import com.pk.cwierkacz.exception.StartException;

public class PropertyReader implements Startable
{
    private static final Logger logger = LoggerFactory.getLogger(PropertyReader.class);

    Properties prop;

    public PropertyReader() {

    }

    public String getProperty( String property, String defaultValue ) {
        if ( prop.containsKey(property) ) {
            return prop.getProperty(property);
        }
        else {
            return defaultValue;
        }
    }

    @Override
    public void start( ) throws StartException {
        prop = new Properties();
        try {
            prop.load(PropertyReader.class.getClassLoader().getResourceAsStream("default.properties"));
            logger.info("Properties Loaded Success: {}", prop.size());

        }
        catch ( IOException ex ) {
            throw new StartException("Property file non existing", ex);
        }
    }

    @Override
    public void stop( ) {
        prop.clear();
        prop = null;
    }
}
