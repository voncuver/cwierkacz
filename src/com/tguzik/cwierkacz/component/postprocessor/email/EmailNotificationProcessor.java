package com.tguzik.cwierkacz.component.postprocessor.email;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.Processor;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;

public class EmailNotificationProcessor implements Processor
{
    public EmailNotificationProcessor( DataAccessor dataAccessor, ImmutableMap<String, String> properties ) {
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
