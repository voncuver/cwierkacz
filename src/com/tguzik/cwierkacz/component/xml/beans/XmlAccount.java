package com.tguzik.cwierkacz.component.xml.beans;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.common.StandardElement;

public class XmlAccount extends StandardElement
{
    private final List<XmlTweet> tweets;
    private String name = StringUtils.EMPTY;

    public XmlAccount() {
        this.tweets = Lists.newArrayList();
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<XmlTweet> getTweets( ) {
        return tweets;
    }

    public void addTweet( XmlTweet tweet ) {
        tweets.add(tweet);
    }
}
