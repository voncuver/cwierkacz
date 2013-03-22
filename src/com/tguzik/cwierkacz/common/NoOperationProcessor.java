package com.tguzik.cwierkacz.common;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;

public final class NoOperationProcessor implements Processor
{
    public static final NoOperationProcessor INSTANCE = new NoOperationProcessor();

    @Override
    public void initialize( ) throws Exception {
    }

    @Override
    public void shutdown( ) {
    }

    @Override
    public void process( ApplicationProcessingData data ) {
    }
}
