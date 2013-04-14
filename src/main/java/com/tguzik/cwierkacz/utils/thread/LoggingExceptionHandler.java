package com.tguzik.cwierkacz.utils.thread;

import java.lang.Thread.UncaughtExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExceptionHandler implements UncaughtExceptionHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingExceptionHandler.class);

    @Override
    public void uncaughtException( Thread t, Throwable e ) {
        LOGGER.error("UNHANDLED EXCEPTION from thread {}: {}", t.getName(), e.getMessage(), e);
    }
}
