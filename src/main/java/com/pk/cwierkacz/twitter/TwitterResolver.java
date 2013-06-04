package com.pk.cwierkacz.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import com.pk.cwierkacz.model.dao.SettingsDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;

public abstract class TwitterResolver
{
    private final SettingsService settingsService = ServiceRepo.getInstance()
                                                               .getService(SettingsService.class);

    protected TwitterFactory factory;

    public TwitterResolver() {
        SettingsDao settings = settingsService.getConsumerSettings();
        if ( settings == null ) {
            factory = new TwitterFactory();
        }
        else {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey(settings.getConsumerKey())
              .setOAuthConsumerSecret(settings.getConsumerSecret());
            factory = new TwitterFactory(cb.build());
        }
    }

    public Twitter createTwitter( AccessToken token ) {
        return factory.getInstance(token);
    }

    public Twitter createTwitter( TwitterAccountDao account, boolean emptyAuth ) throws TwitterAuthenticationException {

        Twitter twitter = null;

        if ( account.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            twitter = createTwitter(token);

        }
        else if ( emptyAuth ) {
            twitter = factory.getInstance();
        }
        else {
            throw new TwitterAuthenticationException("oAuth authentication impossible");
        }

        return twitter;
    }

    public Twitter newTwitter( ) throws TwitterAuthenticationException {

        return factory.getInstance();
    }

}
