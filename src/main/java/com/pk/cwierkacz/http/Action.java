package com.pk.cwierkacz.http;

public enum Action {
    NOTRECOGNIZED( "NOTRECOGNIZED" ),

    SIGNIN( "SIGNIN" ),
    SIGNOUT( "SIGNOUT" ),

    ADDACCOUNT( "ADDACCOUNT" ),
    MODACCOUNT( "MODACCOUNT" ),
    DELACCOUNT( "DELACCOUNT" ),

    FETCHMESSAGES( "FETCHMESSAGES" ),
    FETCHMESSAGE( "FETCHMESSAGE" ),
    FETCHMESSAGEBYID( "FETCHMESSAGEBYID" ),
    PUBLISHMESSAGE( "PUBLISHMESSAGE" ),
    PUBLISHREPLY( "PUBLISHREPLY" ),
    PUBLISHRETWEET( "PUBLISHRETWEET" ),

    LINKSOCIALACCOUNT( "LINKSOCIALACCOUNT" ),
    UNLINKSOCIALACCOUNT( "UNLINKSOCIALACCOUNT" ),
    FETCHSOCIALACCOUNTS( "FETCHSOCIALACCOUNTS" );

    private String actionName;

    Action( String action ) {
        this.actionName = action;
    }

    public String getActionName( ) {
        return actionName;
    }

    public static Action getActionByName( String name ) {
        for ( Action action : Action.values() ) {
            if ( action.getActionName().equals(name) ) {
                return action;
            }
        }
        return NOTRECOGNIZED;
    }
}
