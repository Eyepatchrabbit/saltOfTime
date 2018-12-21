package day;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static day.WeekDayType.WEEKDAY;
import static day.WeekDayType.WEEKEND;

public class DayElementsFactory {

    public static DayElements baseDayElements(LocalDate date) {
        DayElements dayElements=new DayElements();

        DayOfWeek dayOfWeek=weekName(date);

        dayElements.setWeekName(dayOfWeek);

        dayElements.setWeekDayType(weekDayType(dayOfWeek));

        return dayElements;

    }


    protected static DayOfWeek weekName(LocalDate date) {
        return date.getDayOfWeek();
    }


    protected static WeekDayType weekDayType(DayOfWeek dayOfWeek){
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) | dayOfWeek.equals(DayOfWeek.SUNDAY)){
        return WEEKEND;
        }
        return WEEKDAY;
    }


}
