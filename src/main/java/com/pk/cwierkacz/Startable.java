package com.pk.cwierkacz;

import com.pk.cwierkacz.exception.StartException;

public interface Startable
{
    void start( ) throws StartException;

    void stop( );
}
