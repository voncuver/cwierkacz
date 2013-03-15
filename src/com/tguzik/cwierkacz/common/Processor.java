package com.tguzik.cwierkacz.common;

import com.tguzik.cwierkacz.utils.annotation.Initializable;

public interface Processor extends Initializable
{
    void process( ApplicationProcessingData data );
}
