package com.tguzik.cwierkacz.common;

import com.tguzik.cwierkacz.common.data.ApplicationProcessingData;
import com.tguzik.cwierkacz.common.data.RequestedJob;

/**
 * Note: The 'process' method was supposed to take just one argument, but since
 * there could be multiple requested jobs of the same type, it is better to just
 * pass it as an argument.
 */
public interface Processor extends Initializable
{

    void process( ApplicationProcessingData data, RequestedJob job );
}
