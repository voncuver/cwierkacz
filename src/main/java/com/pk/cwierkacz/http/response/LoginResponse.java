package com.pk.cwierkacz.http.response;

import java.util.List;

public interface LoginResponse extends Response
{
    List<String> getAccounts( );

}
