package com.tguzik.cwierkacz.common;


public interface Processor extends Initializable
{
    void process( ApplicationProcessingData data );
}
