package com.tguzik.cwierkacz.common.processing;

public class ApplicationProcessingDataBuilder
{
    private RequestData requestData;

    public ApplicationProcessingDataBuilder withRequestData( RequestData requestData ) {
        this.requestData = requestData;
        return this;
    }

    public ApplicationProcessingData build( ) {
        return new ApplicationProcessingData(requestData);
    }
}
