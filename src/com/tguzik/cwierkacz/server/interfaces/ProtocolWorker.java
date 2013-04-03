package com.tguzik.cwierkacz.server.interfaces;

import java.io.InputStream;

import com.google.common.base.Function;
import com.tguzik.cwierkacz.utils.annotation.SingleThreaded;

@SingleThreaded
public interface ProtocolWorker extends Function<InputStream, String>
{
    void postprocessing( ) throws Exception;

    String produceErrorResponse( Exception e );
}
