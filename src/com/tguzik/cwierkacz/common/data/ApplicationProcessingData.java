package com.tguzik.cwierkacz.common.data;

import com.google.common.collect.ImmutableMap;
import com.tguzik.cwierkacz.cache.dataobject.Customer;
import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;
import com.tguzik.cwierkacz.common.StandardElement;
import com.tguzik.cwierkacz.common.data.value.FunctionalAccountName;
import com.tguzik.cwierkacz.utils.annotation.Immutable;

@Immutable
public final class ApplicationProcessingData extends StandardElement
{
    // What was requested
    private final RequestData requestData;

    // Information we pulled from cache/database
    private final Customer customer;
    private final ImmutableMap<FunctionalAccountName, FunctionalAccount> accountsByName;

    // Placeholder for the response
    private final ResponseDataBuilder responseDataBuilder;

    ApplicationProcessingData( Customer owner,
                               RequestData requestData,
                               ImmutableMap<FunctionalAccountName, FunctionalAccount> accountsByName ) {
        this.responseDataBuilder = ResponseData.builder();
        this.accountsByName = accountsByName;
        this.requestData = requestData;
        this.customer = owner;
    }

    /** Immutable representation of the request */
    public RequestData getRequestData( ) {
        return requestData;
    }

    /** Pulled from cache/database in preprocessing based on RequestData */
    public Customer getCustomer( ) {
        return customer;
    }

    /** Pulled from cache/database in preprocessing based on RequestData */
    public ImmutableMap<FunctionalAccountName, FunctionalAccount> getAccountsByName( ) {
        return accountsByName;
    }

    /** Placeholder */
    public ResponseDataBuilder getResponseDataBuilder( ) {
        return responseDataBuilder;
    }

    public static ApplicationProcessingDataBuilder builder( ) {
        return new ApplicationProcessingDataBuilder();
    }
}
