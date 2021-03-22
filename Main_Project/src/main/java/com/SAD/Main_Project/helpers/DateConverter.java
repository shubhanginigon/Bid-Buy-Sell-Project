package com.SAD.Main_Project.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateConverter {

    public LocalDateTime convertToLocalDateTimeFromString(String dateTime) {
        String[] dateAndTime = dateTime.split("T");
        LocalDate date = LocalDate.parse(dateAndTime[0]);
        LocalTime time = LocalTime.parse(dateAndTime[1]);

        return LocalDateTime.of(date, time);
    }

}
