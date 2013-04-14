package com.tguzik.cwierkacz.common.processing;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.common.processing.traits.Processor;

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
    public void process( ApplicationProcessingData data, RequestedJob job ) {
    }
}
