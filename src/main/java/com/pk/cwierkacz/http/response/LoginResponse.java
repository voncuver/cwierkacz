package com.pk.cwierkacz.http.response;

import java.util.Set;

public interface LoginResponse extends Response
{
    Set<String> getAccounts( );

}
