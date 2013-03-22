package com.tguzik.cwierkacz.common.data;

public class ApplicationProcessingDataBuilder
{
    private RequestData requestData;
    private Owner owner;

    public ApplicationProcessingDataBuilder withOwner( Owner owner ) {
        this.owner = owner;
        return this;
    }

    public ApplicationProcessingDataBuilder withRequestData( RequestData requestData ) {
        this.requestData = requestData;
        return this;
    }

    public ApplicationProcessingData build( ) {
        return new ApplicationProcessingData(owner, requestData);
    }
}
