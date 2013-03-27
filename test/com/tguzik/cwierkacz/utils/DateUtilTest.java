package com.tguzik.cwierkacz.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class DateUtilTest
{

    @Test
    public void testFormatterUTC( ) {
        DateTime expected = new DateTime(2013, 3, 25, 12, 20, 33, 123, DateTimeZone.UTC);

        assertNotNull(DateUtil.formatterUTC());
        assertEquals(DateTimeZone.UTC, DateUtil.formatterUTC().getZone());
        assertEquals(expected, DateUtil.formatterUTC().parseDateTime("20130325T122033.123Z"));
    }

    @Test
    public void testFormatterYyyyMMddUTC( ) {
        DateTime expected = new DateTime(2013, 3, 25, 0, 0, 0, DateTimeZone.UTC);

        assertNotNull(DateUtil.formatterYyyyMMddUTC());
        assertEquals(DateTimeZone.UTC, DateUtil.formatterYyyyMMddUTC().getZone());
        assertEquals(expected, DateUtil.formatterYyyyMMddUTC().parseDateTime("2013-03-25"));
    }

    @Test
    public void testDateNowUTC( ) {
        DateTime expected = DateTime.now(DateTimeZone.UTC);
        DateTime actual = DateUtil.dateNowUTC();

        assertEquals(expected, actual);
    }

    @Test
    public void testConvert( ) {
        DateTime expected = new DateTime(2013, 3, 25, 20, 27, 29, 982, DateTimeZone.UTC);
        java.util.Date utilDate = new java.util.Date(1364243249982L);

        assertEquals(expected, DateUtil.convertDateUTC(utilDate));
    }
}
