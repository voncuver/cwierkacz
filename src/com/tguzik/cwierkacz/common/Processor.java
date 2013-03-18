package com.tguzik.cwierkacz.common;

import com.tguzik.cwierkacz.common.processing.ApplicationProcessingData;


public interface Processor extends Initializable
{
    void process( ApplicationProcessingData data );
}
