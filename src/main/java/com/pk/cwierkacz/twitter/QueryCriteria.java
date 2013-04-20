package com.pk.cwierkacz.twitter;

import org.joda.time.LocalDate;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;

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

    private final TwitterAccountDao from;

    private final TwitterAccountDao to;

    private QueryCriteria( TwitterAccountDao from,
                           TwitterAccountDao to,
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
    public TwitterAccountDao getFrom( ) {
        return from;
    }

    /**
     * tweet recipient
     */
    public TwitterAccountDao getTo( ) {
        return to;
    }

    public static QueryCriteria full( TwitterAccountDao from,
                                      TwitterAccountDao to,
                                      LocalDate sinceDate,
                                      LocalDate untilDate ) {
        return new QueryCriteria(from, to, sinceDate, untilDate);
    }

    public static QueryCriteria from( TwitterAccountDao from ) {
        return new QueryCriteria(from, null, null, null);
    }

    public static QueryCriteria to( TwitterAccountDao to ) {
        return new QueryCriteria(null, to, null, null);
    }

    public static QueryCriteria since( LocalDate since ) {
        return new QueryCriteria(null, null, since, null);
    }

    public static QueryCriteria until( LocalDate until ) {
        return new QueryCriteria(null, null, null, until);
    }

    public static QueryCriteria participants( TwitterAccountDao from, TwitterAccountDao to ) {
        return new QueryCriteria(from, to, null, null);
    }

    public static QueryCriteria interval( LocalDate since, LocalDate until ) {
        return new QueryCriteria(null, null, since, until);
    }
}
