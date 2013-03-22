package com.tguzik.cwierkacz.component.processor.twitter;

import java.util.concurrent.ThreadPoolExecutor;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;

public class FetcherProcessor implements Processor
{

    public FetcherProcessor( DataAccessor dataAccessor,
                             ImmutableMap<String, String> properties,
                             ThreadPoolExecutor endpointThreadPool ) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void process( ApplicationProcessingData data ) {

    }

    @Override
    public void initialize( ) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void shutdown( ) {
        // TODO Auto-generated method stub

    }
}
