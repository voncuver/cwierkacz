package com.tguzik.cwierkacz.twitter.converters;

import java.util.Date;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConverter
{

    private final Logger log = LoggerFactory.getLogger(DateConverter.class);

    /**
     * Method which convert date to string YYYY-MM-DD
     * 
     * @param date
     * @return
     */
    public String toTruncateStringDate( LocalDate date ) {
        String year = Integer.toString(date.getYear());
        String month = Integer.toString(date.getMonthOfYear());
        String days = Integer.toString(date.getDayOfMonth());

        if ( month.length() < 2 )
            month = "0" + month;
        if ( days.length() < 2 )
            days = "0" + days;

        return year + "-" + month + "-" + days;
    }

    /**
     * Method which convert string YYYY-MM-DD do date
     * 
     * @param stringDate
     * @return
     * @throws FormatException
     */
    public LocalDate toDate( String stringDate ) throws FormatException {
        String[] spliitedDates = stringDate.split("-");
        FormatException exception = new FormatException("Incorrect date. Date must have format YYYY-MM-DD");
        if ( spliitedDates.length != 3 ) {
            log.error(exception.getMessage());
            throw exception;
        }
        //TODO more validation

        LocalDate date;
        try {
            date = new LocalDate(Integer.parseInt(spliitedDates[ 0 ]),
                                 Integer.parseInt(spliitedDates[ 1 ]),
                                 Integer.parseInt(spliitedDates[ 2 ]));
        }
        catch ( NumberFormatException ex ) {
            log.error(ex.getMessage());
            throw ex;
        }

        return date;
    }

    /**
     * Method which convert java.util.Date to joda LocalDate
     * 
     * @param date
     * @return
     */
    public LocalDate toDate( Date date ) {
        return new LocalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }
}
