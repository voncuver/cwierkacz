package com.tguzik.cwierkacz.application;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.application.initialization.ApplicationInitializator;

public class Cwierkacz
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Cwierkacz.class);

    public static void main( String[] args ) {
        try {
            LOGGER.info("Starting up...");
            ApplicationContext context = new ApplicationInitializator().initializeContext(parseCommandLine(args));
            LOGGER.info("Initialization complete.");

            System.out.println(ReflectionToStringBuilder.toString(context, ToStringStyle.MULTI_LINE_STYLE));

            new Application(context).run();
        }
        catch ( Exception e ) {
            LOGGER.error("Unexpected exception: " + e.getMessage(), e);
        }
        finally {
            LOGGER.info("Shutting down.");
        }
    }

    private static CommandLine parseCommandLine( String[] args ) throws ParseException {
        Options opt = new Options().addOption("conf", "configuration-path", true, "Path to configuration directory");
        return new PosixParser().parse(opt, args, true);
    }
}
