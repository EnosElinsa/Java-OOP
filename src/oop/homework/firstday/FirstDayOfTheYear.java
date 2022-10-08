package oop.homework.firstday;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FirstDayOfTheYear {
    public static int getFirstDayofTheYear(int year) {
        LocalDate firstDayOfTheYear = LocalDate.of(year, 1, 1);
        DayOfWeek weekday = firstDayOfTheYear.getDayOfWeek();
        return weekday.getValue() > 6 ? 0 : weekday.getValue();
    }
}

