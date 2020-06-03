package com.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMapper {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date currentDateFormatted() {
        Date currentDate = new Date();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            currentDate = formatter.parse(new Date().toString());
        } catch (ParseException e) {
        }
        return currentDate;
    }

    public static String currentDateInStringFormatted() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    public static String convertDateInDateToStringFormatted(String date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static String convertDateInDateToStringFormatted(Date date) {
        if (date != null) {
            return new SimpleDateFormat(DATE_FORMAT).format(date);
        }
        return null;
    }

    public static Date retrieveLimitExpirationDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date convertStringFormatted(String date) {
        Date result = null;
        try {
            result = new SimpleDateFormat(DATE_FORMAT).parse(date);
        } catch (ParseException e) {
        }
        return result;
    }
}
