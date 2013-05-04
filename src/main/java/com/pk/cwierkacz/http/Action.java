package com.pk.cwierkacz.http;

public enum Action {
    NOTRECOGNIZED( "NOTRECOGNIZED" ),

    SIGNIN( "SIGNIN" ),
    SIGNOUT( "SIGNOUT" ),

    ADDACCOUNT( "ADDACCOUNT" ),
    MODACCOUNT( "MODACCOUNT" ),
    DELACCOUNT( "DELACCOUNT" ),

    FETCHTWEETS( "FETCHTWEETS" ),
    PUBLISHTWEET( "PUBLISHTWEET" ),

    ADDTWEETACCOUNT( "ADDTWEETACCOUNT" ),
    DELTWEETACCOUNT( "DELTWEETACCOUNT" ),
    FETCHTWEETACCOUNTS( "FETCHTWEETACCOUNTS" );

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
