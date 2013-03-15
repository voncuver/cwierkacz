package com.tguzik.cwierkacz.application;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cwierkacz
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Cwierkacz.class);

    public static void main( String[] args ) {
        ApplicationContextLoader initializator = new ApplicationContextLoader();
        ApplicationContext context = null;

        try {
            LOGGER.info("Starting up...");
            context = initializator.initialize(parseCommandLine(args));
            LOGGER.info("Initialization complete.");

            System.out.println(ReflectionToStringBuilder.toString(context, ToStringStyle.MULTI_LINE_STYLE));

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

    private static CommandLine parseCommandLine( String[] args ) throws ParseException {
        Options opt = new Options().addOption("conf", "configuration-path", true, "Path to configuration directory");
        return new PosixParser().parse(opt, args, true);
    }
}
