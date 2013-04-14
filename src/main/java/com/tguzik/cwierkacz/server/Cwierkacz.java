package com.tguzik.cwierkacz.server;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tguzik.cwierkacz.server.initialization.ApplicationInitialization;

public class Cwierkacz
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Cwierkacz.class);

    public static void main( String[] args ) {
        ApplicationContext context = null;

        try {
            LOGGER.info("Starting up...");
            context = new ApplicationInitialization(getConfigurationDirectory(args)).initialize();
            LOGGER.info("Initialization complete.");

            Application.createAndRun(context);
        }
        catch ( Exception e ) {
            LOGGER.error("Unexpected exception: " + e.getMessage(), e);
        }
        finally {
            ApplicationContextDeactivator.deactivate(context);
            LOGGER.info("Shutting down...");
            System.exit(0);
        }
    }

    private static String getConfigurationDirectory( String[] args ) throws ParseException {
        return parseCommandLine(args).getOptionValue("conf");
    }

    private static CommandLine parseCommandLine( String[] args ) throws ParseException {
        Options opt = new Options().addOption("conf",
                                              "configuration-path",
                                              true,
                                              "Path to configuration directory");
        return new PosixParser().parse(opt, args, true);
    }
}
