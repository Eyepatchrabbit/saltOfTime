package day;

import java.time.DayOfWeek;

public class DayElements {

    private DayOfWeek weekName;

    private WeekDayType weekDayType;


    public void setWeekName(DayOfWeek weekName) {
        this.weekName = weekName;
    }

    public DayOfWeek getWeekName() {
        return weekName;
    }


    public WeekDayType getWeekDayType() {
        return weekDayType;
    }

    public void setWeekDayType(WeekDayType weekDayType) {
        this.weekDayType = weekDayType;
    }

}
