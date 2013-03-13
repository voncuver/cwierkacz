package com.tguzik.cwierkacz.deployment;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cwierkacz implements Runnable
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Cwierkacz.class);

    public static void main( String[] args ) {
        LOGGER.info("Starting up...");
        try {
            CommandLine cli = parseCommandLine(args);
            new Cwierkacz(cli).run();
        }
        catch ( Exception e ) {
            LOGGER.error("Unexpected exception: " + e.getMessage(), e);
        }
        finally {
            LOGGER.info("Shutting down.");
        }
    }

    private final CommandLine commandLine;

    public Cwierkacz( CommandLine commandLine ) {
        this.commandLine = commandLine;
    }

    @Override
    public void run( ) {

    }

    private static CommandLine parseCommandLine( String[] args ) throws ParseException {
        Options opt = new Options().addOption("conf", "configuration-path", true, "Path to configuration directory");
        return new PosixParser().parse(opt, args, true);
    }
}
