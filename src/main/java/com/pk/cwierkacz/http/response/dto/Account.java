package com.pk.cwierkacz.http.response.dto;

import com.pk.cwierkacz.model.AccountType;

public class Account
{

    public String login;
    public String name;
    public AccountType type;

    public Account() {
    }

    public Account( String login, String name, AccountType accountType ) {
        this.login = login;
        this.name = name;
        this.type = accountType;
    }

    public String getLogin( ) {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public AccountType getType( ) {
        return type;
    }

    public void setType( AccountType type ) {
        this.type = type;
    }

}
