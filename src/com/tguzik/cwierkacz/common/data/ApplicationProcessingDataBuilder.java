package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.dataobject.Customer;
import com.tguzik.cwierkacz.cache.dataobject.TwitterAccount;
import com.tguzik.cwierkacz.common.data.value.TwitterAccountName;

public class ApplicationProcessingDataBuilder
{
    private final ImmutableMap.Builder<TwitterAccountName, TwitterAccount> accountsByName;
    private RequestData requestData;
    private Customer customer;

    public ApplicationProcessingDataBuilder() {
        this.accountsByName = ImmutableMap.builder();
    }

    public ApplicationProcessingDataBuilder withCustomer( Customer customer ) {
        this.customer = customer;
        return this;
    }

    public ApplicationProcessingDataBuilder withRequestData( RequestData requestData ) {
        this.requestData = requestData;
        return this;
    }

    public ApplicationProcessingDataBuilder withRequestData( TwitterAccountName name, TwitterAccount account ) {
        this.accountsByName.put(name, account);
        return this;
    }

    public ApplicationProcessingData build( ) {
        return new ApplicationProcessingData(customer, requestData, accountsByName.build());
    }
}
