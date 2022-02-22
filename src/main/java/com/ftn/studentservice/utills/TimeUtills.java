package com.ftn.studentservice.utills;

public class TimeUtills {
    public static java.time.LocalDateTime jodaToJavaLocalDateTime(org.joda.time.LocalDateTime localDateTime) {
        return java.time.LocalDateTime.of(
                localDateTime.getYear(),
                localDateTime.getMonthOfYear(),
                localDateTime.getDayOfMonth(),
                localDateTime.getHourOfDay(),
                localDateTime.getMinuteOfHour(),
                localDateTime.getSecondOfMinute(),
                0);

    }

}