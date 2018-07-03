package com.ning.springbootdemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

    public static void main(String[] args) {
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate date = LocalDate.now();
        System.out.println(date.format(dateFmt));
        LocalDate add29 = date.plusDays(29);
        System.out.println(add29.format(dateFmt));

        LocalDateTime time = LocalDateTime.of(date, LocalTime.of(LocalTime.now().getHour(), 0, 0, 0));
        System.out.println(time.format(dateTimeFmt));
        LocalDateTime addOneHour = time.plusHours(1);
        System.out.println(addOneHour.format(dateTimeFmt));

    }

}
