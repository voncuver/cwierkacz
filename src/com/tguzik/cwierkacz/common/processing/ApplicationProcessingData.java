package com.tguzik.cwierkacz.common.processing;

import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationProcessingData
{
    private final RequestData requestData;

    ApplicationProcessingData( RequestData requestData ) {
        this.requestData = requestData;
    }

    public RequestData getRequestData( ) {
        return requestData;
    }

    public static ApplicationProcessingDataBuilder builder( ) {
        return new ApplicationProcessingDataBuilder();
    }
}
