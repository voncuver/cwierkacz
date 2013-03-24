package com.tguzik.cwierkacz.twitter.converters;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class DateConverterTest
{

    private final LocalDate localDate = new LocalDate(2013, 3, 24);
    private final String stringDate = "2013-03-24";
    private final Date utilDate = new Date(113, 2, 24);
    private final DateConverter converter = new DateConverter();

    @Before
    public void setUp( ) throws Exception {
    }

    @Test
    public void toTruncateStringDateTest( ) {
        assertEquals(converter.toTruncateStringDate(localDate), stringDate);
    }

    @Test
    public void toDateFromDateTest( ) {
        assertEquals(converter.toDate(utilDate), localDate);
    }

    @Test
    public void toDateFromStringTest( ) throws FormatException {
        assertEquals(converter.toDate(stringDate), localDate);
    }
}
