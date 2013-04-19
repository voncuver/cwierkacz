package com.tguzik.cwierkacz.twitter;

import org.joda.time.LocalDate;

import com.tguzik.cwierkacz.cache.dataobject.FunctionalAccount;

/**
 * @author radek
 * 
 *         Defines some criteria to query tweets
 * 
 */
public class QueryCriteria
{
    private final LocalDate sinceDate;

    private final LocalDate untilDate;

    private final FunctionalAccount from;

    private final FunctionalAccount to;

    private QueryCriteria( FunctionalAccount from,
                           FunctionalAccount to,
                           LocalDate sinceDate,
                           LocalDate untilDate ) {
        this.from = from;
        this.to = to;
        this.sinceDate = sinceDate;
        this.untilDate = untilDate;
    }

    /**
     * min date of tweet - important! LocalDate will be truncate to date
     */
    public LocalDate getSinceDate( ) {
        return sinceDate;
    }

    /**
     * max date of tweet - important! LocalDate will be truncate to date
     */
    public LocalDate getUntilDate( ) {
        return untilDate;
    }

    /**
     * tweet sender
     */
    public FunctionalAccount getFrom( ) {
        return from;
    }

    /**
     * tweet recipient
     */
    public FunctionalAccount getTo( ) {
        return to;
    }

    public static QueryCriteria full( FunctionalAccount from,
                                      FunctionalAccount to,
                                      LocalDate sinceDate,
                                      LocalDate untilDate ) {
        return new QueryCriteria(from, to, sinceDate, untilDate);
    }

    public static QueryCriteria from( FunctionalAccount from ) {
        return new QueryCriteria(from, null, null, null);
    }

    public static QueryCriteria to( FunctionalAccount to ) {
        return new QueryCriteria(null, to, null, null);
    }

    public static QueryCriteria since( LocalDate since ) {
        return new QueryCriteria(null, null, since, null);
    }

    public static QueryCriteria until( LocalDate until ) {
        return new QueryCriteria(null, null, null, until);
    }

    public static QueryCriteria participants( FunctionalAccount from, FunctionalAccount to ) {
        return new QueryCriteria(from, to, null, null);
    }

    public static QueryCriteria interval( LocalDate since, LocalDate until ) {
        return new QueryCriteria(null, null, since, until);
    }
}
