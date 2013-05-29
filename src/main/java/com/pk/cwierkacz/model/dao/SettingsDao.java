package com.pk.cwierkacz.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Settings" )
public class SettingsDao
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( unique = true, nullable = false )
    private String settings;

    private String consumerKey;

    private String consumerSecret;

    private String relativeImgPath;

    private String absoluteContainerPath;

    private String appAddress;

    public Long getId( ) {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Column( unique = true, nullable = false )
    public String getSettings( ) {
        return settings;
    }

    public void setSettings( String settings ) {
        this.settings = settings;
    }

    public String getConsumerKey( ) {
        return consumerKey;
    }

    public void setConsumerKey( String consumerKey ) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret( ) {
        return consumerSecret;
    }

    public void setConsumerSecret( String consumerSecret ) {
        this.consumerSecret = consumerSecret;
    }

    public String getRelativeImgPath( ) {
        return relativeImgPath;
    }

    public void setRelativeImgPath( String relativeImgPath ) {
        this.relativeImgPath = relativeImgPath;
    }

    public String getAbsoluteContainerPath( ) {
        return absoluteContainerPath;
    }

    public void setAbsoluteContainerPath( String absoluteContainerPath ) {
        this.absoluteContainerPath = absoluteContainerPath;
    }

    public String getAppAddress( ) {
        return appAddress;
    }

    public void setAppAddress( String appAddress ) {
        this.appAddress = appAddress;
    }

}
