package com.pk.cwierkacz.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.pk.cwierkacz.model.AccountType;

@Entity
@Table( name = "BridgeImgMetadata" )
public class BridgeImgMetadataDao
{

    @Id
    @Column( length = 255 )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String bridgeId;

    private AccountType accountType;

    private String lss;

    private String path;

    @Column
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    private DateTime accessDate = new DateTime();

    public String getBridgeId( ) {
        return bridgeId;
    }

    public void setBridgeId( String bridgeId ) {
        this.bridgeId = bridgeId;
    }

    public String getLss( ) {
        return lss;
    }

    public void setLss( String lss ) {
        this.lss = lss;
    }

    public String getPath( ) {
        return path;
    }

    public void setPath( String path ) {
        this.path = path;
    }

    @Column
    @Type( type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime" )
    public DateTime getAccessDate( ) {
        return accessDate;
    }

    public void setAccessDate( DateTime accessDate ) {
        this.accessDate = accessDate;
    }

    public AccountType getAccountType( ) {
        return accountType;
    }

    public void setAccountType( AccountType accountType ) {
        this.accountType = accountType;
    }

}
