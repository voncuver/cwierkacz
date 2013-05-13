package com.pk.cwierkacz.processor.handlers;

import com.pk.cwierkacz.model.ApplicationData;

public interface Handler
{
    boolean isHandleable( ApplicationData applicationData );

    void handleWithSecurity( ApplicationData appData );
}
