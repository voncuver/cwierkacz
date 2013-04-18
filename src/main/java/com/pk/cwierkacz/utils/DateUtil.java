package com.pk.cwierkacz.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class DateUtil
{
    private static final DateTimeFormatter FORMATTER_FULL = ISODateTimeFormat.basicDateTime().withZoneUTC();

    private static final DateTimeFormatter FORMATTER_DATE_ONLY = DateTimeFormat.forPattern("yyyy-MM-dd")
                                                                               .withZoneUTC();

    public static DateTimeFormatter formatterUTC( ) {
        return FORMATTER_FULL;
    }

    public static DateTimeFormatter formatterYyyyMMddUTC( ) {
        return FORMATTER_DATE_ONLY;
    }

    public static DateTime dateNowUTC( ) {
        return DateTime.now(DateTimeZone.UTC);
    }

    public static DateTime convertDateUTC( java.util.Date date ) {
        return new DateTime(date, DateTimeZone.UTC);
    }
}
