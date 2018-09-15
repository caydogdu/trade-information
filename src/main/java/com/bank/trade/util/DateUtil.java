package com.bank.trade.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public final class DateUtil {

    private static DateTimeFormatter[] dateFormats =
            { null, DateTimeFormatter.ofPattern("yyyy-MMd"), DateTimeFormatter.ofPattern("yyyyMM-d") };

    /**
     * This method checks whether the given date object is representing a date at the weekend (Saturday or Sunday)
     *
     * @param date Date to check, cannot be null
     * @return TRUE is Saturday or Sunday
     */
    public static boolean isWeekend(LocalDate date) {
        if (date == null) {
            return false;
        }
        DayOfWeek dayOfWeek = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
        switch (dayOfWeek) {
        case SATURDAY:
        case SUNDAY:
            return true;
        default:
            return false;
        }
    }

    private static LocalDate parseDate(String date, DateTimeFormatter formatter) {
        if (formatter == null) {
            return LocalDate.parse(date);
        }
        return LocalDate.parse(date, formatter);
    }

    public static LocalDate toLocalDateForStringDate(String date) {

        if (date == null) {
            return null;
        }

        LocalDate localDate = null;
        for (int i = 0; i < dateFormats.length; i++) {
            try {
                localDate = parseDate(date, dateFormats[i]);
            } catch (Exception e) {
                localDate = null;
            }
            if (localDate != null) {
                return localDate;
            }
        }

        return null;

    }

    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

}
