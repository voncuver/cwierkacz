package com.tguzik.cwierkacz.component.xml.beans;

import java.util.List;

import com.google.common.collect.Lists;
import com.tguzik.cwierkacz.common.StandardElement;

public class XmlJob extends StandardElement
{
    private final List<XmlAccount> accounts;
    private boolean cacheOnly = false;
    private String name;

    public XmlJob() {
        this.accounts = Lists.newArrayList();
    }

    public String getName( ) {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public boolean isCacheOnly( ) {
        return cacheOnly;
    }

    public void setCacheOnly( boolean cacheOnly ) {
        this.cacheOnly = cacheOnly;
    }

    public List<XmlAccount> getAccounts( ) {
        return accounts;
    }

    public void addAccount( XmlAccount account ) {
        accounts.add(account);
    }
}
