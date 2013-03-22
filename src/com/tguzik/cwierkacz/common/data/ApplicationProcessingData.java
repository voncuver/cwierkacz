package com.tguzik.cwierkacz.common.data;

import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationProcessingData extends StandardElement
{
    private final Owner owner;
    private final RequestData requestData;
    private final ResponseDataBuilder responseDataBuilder;

    ApplicationProcessingData( Owner owner, RequestData requestData ) {
        this.owner = owner;
        this.requestData = requestData;

        this.responseDataBuilder = ResponseData.builder();
    }

    public Owner getOwner( ) {
        return owner;
    }

    public RequestData getRequestData( ) {
        return requestData;
    }

    public ResponseDataBuilder getResponseDataBuilder( ) {
        return responseDataBuilder;
    }

    public static ApplicationProcessingDataBuilder builder( ) {
        return new ApplicationProcessingDataBuilder();
    }
}
