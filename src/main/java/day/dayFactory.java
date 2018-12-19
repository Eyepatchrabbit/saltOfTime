package day;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class dayFactory {

    public static DayOfWeek weekName(LocalDate date) {
        return date.getDayOfWeek();
    }

}
