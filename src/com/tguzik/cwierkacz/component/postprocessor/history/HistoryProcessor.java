package com.tguzik.cwierkacz.component.postprocessor.history;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestedJob;

public class HistoryProcessor implements Processor
{
    public HistoryProcessor( DataAccessor dataAccessor, ImmutableMap<String, String> properties ) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void process( ApplicationProcessingData data, RequestedJob job ) {

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
