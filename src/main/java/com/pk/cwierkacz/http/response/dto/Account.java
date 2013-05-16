package com.pk.cwierkacz.http.response.dto;

import com.pk.cwierkacz.model.AccountType;

public class Account
{

    public String login;
    public AccountType type;

    public Account() {
    }

    public Account( String name, AccountType accountType ) {
        this.login = name;
        this.type = accountType;
    }

    public String getLogin( ) {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public AccountType getType( ) {
        return type;
    }

    public void setType( AccountType type ) {
        this.type = type;
    }

}
