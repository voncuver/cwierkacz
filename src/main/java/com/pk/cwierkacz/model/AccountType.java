package com.pk.cwierkacz.model;

public enum AccountType {

    TWITTER( "TWITTER" ),
    FACEBOOKBRIDGE( "FACEBOOKBRIDGE" ),
    TWITPICBRIDGE( "TWITPICBRIDGE" ),
    FLICKERBRIDGE( "FLICKERBRIDGE" );

    private String type;

    AccountType( String type ) {
        this.type = type;
    }

    public String getType( ) {
        return type;
    }

    public static AccountType getAccountType( String accountType ) {
        for ( AccountType account : AccountType.values() ) {
            if ( account.getType().toUpperCase().equals(accountType) ) {
                return account;
            }
        }
        return null;
    }
}
