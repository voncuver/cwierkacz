package com.tguzik.cwierkacz.server.interfaces;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestData;
import com.tguzik.cwierkacz.common.processing.traits.Initializable;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public interface ProtocolWorker extends Initializable
{
    RequestData createRequestData( String request ) throws Exception;

    String createResponse( ApplicationProcessingData data ) throws Exception;

    String produceErrorResponse( Exception e );

    String produceEmptyRequestResponse( );
}
