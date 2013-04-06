package com.tguzik.cwierkacz.component.processor.account;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.DataAccessor;
import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestedJob;
import com.tguzik.cwierkacz.common.processing.traits.Processor;

public class AccountCreatorProcessor implements Processor
{

    public AccountCreatorProcessor( DataAccessor dataAccessor, ImmutableMap<String, String> properties ) {
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
