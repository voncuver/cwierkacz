package com.pk.cwierkacz.model.http;

public enum Action {
    NOTRECOGNIZED( "NotRecognized" ),

    LOGIN( "Login" ),
    CREATEACCOUNT( "Create" ),
    PUBLISHTWEET( "PublishTweet" );

    private String actionName;

    Action( String action ) {
        this.actionName = action;
    }

    public String getActionName( ) {
        return actionName;
    }

    public Action getActionByName( String name ) {
        for ( Action action : Action.values() ) {
            if ( action.getActionName().equals(name) ) {
                return action;
            }
        }
        return NOTRECOGNIZED;
    }
}
