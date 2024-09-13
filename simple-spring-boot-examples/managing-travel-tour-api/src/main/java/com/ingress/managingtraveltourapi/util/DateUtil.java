package com.ingress.managingtraveltourapi.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime stringToLocalDateTime(String date) {
        if (date == null) {
            return null;
        }
        return LocalDate.parse(date, DATE_TIME_FORMATTER).atStartOfDay();
    }
}
