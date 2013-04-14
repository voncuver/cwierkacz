package com.tguzik.cwierkacz.component.xml.beans;

import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.common.StandardElement;

public class XmlTweet extends StandardElement
{
    private Long id;
    private DateTime date;
    private String account;
    private String content;
    private final List<XmlTweet> replies;

    public XmlTweet() {
        this.replies = Lists.newArrayList();
    }

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public DateTime getDate( ) {
        return date;
    }

    public void setDate( DateTime date ) {
        this.date = date;
    }

    public String getAccount( ) {
        return account;
    }

    public void setAccount( String account ) {
        this.account = account;
    }

    public String getContent( ) {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public List<XmlTweet> getReplies( ) {
        return replies;
    }

    public void addReply( XmlTweet tweet ) {
        this.replies.add(tweet);
    }
}
