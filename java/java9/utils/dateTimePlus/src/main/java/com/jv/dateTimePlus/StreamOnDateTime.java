package com.jv.dateTimePlus;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

/**
 * More on time new specs ??? :
 * https://blog.joda.org/2017/02/java-time-jsr-310-enhancements-java-9.html
 */
public class StreamOnDateTime {

    public static void main(String args[]){
        List<LocalDate> dates = LocalDate.now()
                .datesUntil(LocalDate.now()
                .plusDays(7))
                .collect(Collectors.toList());
        dates.forEach(System.out::println);
        System.out.println("Version with period");
        dates = LocalDate.now()
                .datesUntil(LocalDate.now()
                        .plusDays(7), Period.ofDays(2))
                .collect(Collectors.toList());
        dates.forEach(System.out::println);
    }
}
