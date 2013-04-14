package com.tguzik.cwierkacz.utils.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class ThreadUtils
{
    public static BasicThreadFactory createThreadFactory( String threadNamePrefix ) {
        return new BasicThreadFactory.Builder().namingPattern(threadNamePrefix + "-pool-%d")
                                               .uncaughtExceptionHandler(new LoggingExceptionHandler())
                                               .build();
    }
}
