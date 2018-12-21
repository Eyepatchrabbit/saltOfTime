package day;

import java.time.LocalDate;

import static day.DayElementsFactory.baseDayElements;

public class DayFactory {

    public static Day basicDayFacory(LocalDate date) {

        //add elements of the day
        Day day = new Day(date);

        //add basics of the DayElements

        day.setDayElements(baseDayElements(date));

        return day;

    }
}
