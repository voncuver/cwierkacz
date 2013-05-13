package com.pk.cwierkacz.model;

public enum AccountType {

    TWITTER( "twitter" ),
    FACEBOOKBRIDGE( "facebookBridge" ),
    TWITPICBRIDGE( "twitpicBridge" ),
    FLICKERBRIDGE( "flickrBridge" );

    private String type;

    AccountType( String type ) {
        this.type = type;
    }

    public String getType( ) {
        return type;
    }

    public static AccountType getAccountType( String accountType ) {
        for ( AccountType account : AccountType.values() ) {
            if ( account.getType().equals(accountType) ) {
                return account;
            }
        }
        return null;
    }
}
