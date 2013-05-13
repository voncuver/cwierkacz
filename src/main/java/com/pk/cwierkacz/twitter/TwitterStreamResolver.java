package com.pk.cwierkacz.twitter;

import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import com.pk.cwierkacz.model.dao.SettingsDao;
import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.service.ServiceRepo;
import com.pk.cwierkacz.model.service.SettingsService;

public abstract class TwitterStreamResolver
{
    private final SettingsService settingsService = ServiceRepo.getInstance()
                                                               .getService(SettingsService.class);

    protected TwitterStreamFactory factory;

    public TwitterStreamResolver() {
        SettingsDao settings = settingsService.getConsumerSettings();
        if ( settings == null ) {
            factory = new TwitterStreamFactory();
        }
        else {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
              .setOAuthConsumerKey(settings.getConsumerKey())
              .setOAuthConsumerSecret(settings.getConsumerSecret());
            factory = new TwitterStreamFactory(cb.build());
        }
    }

    public TwitterStream createTwitterStream( TwitterAccountDao account, boolean emptyAuth ) throws TwitterAuthenticationException {

        TwitterStream twitter = null;

        if ( account.isOAuthAvailable() ) {
            AccessToken token = new AccessToken(account.getAccessToken(), account.getAccessTokenSecret());
            twitter = factory.getInstance(token);

        }
        else if ( emptyAuth ) {
            twitter = factory.getInstance();
        }
        else {
            throw new TwitterAuthenticationException("oAuth authentication impossible");
        }

        return twitter;
    }

}
