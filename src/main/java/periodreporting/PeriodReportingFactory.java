package periodreporting;

import day.Day;
import day.WeekDayType;
import period.Period;

import java.util.List;

public class PeriodReportingFactory {

    public static PeriodReporting makeReportOfPeriod(List<Day> daylistPeriod){
        PeriodReporting periodReporting=new PeriodReporting();

        int totalTimeDifference = 0;
        int totalDaysFilledIn = 0;
        int totalNumberWeekdays = 0;

        for (Day dayInPeriod:daylistPeriod) {
            if (dayInPeriod.getTimeDifference()!=(null)){
                totalTimeDifference=totalTimeDifference+dayInPeriod.getTimeDifference().getTimeDifferenceInputted();

                totalDaysFilledIn++;

                if (dayInPeriod.getDayElements().getWeekDayType().equals(WeekDayType.WEEKDAY)){
                    totalNumberWeekdays++;
                }

            }
        }

        periodReporting.setTotalTimeDifference(totalTimeDifference);
        periodReporting.setTotalDaysFilledIn(totalDaysFilledIn);
        periodReporting.setTotalNumberWeekdays(totalNumberWeekdays);

        return periodReporting;
    }

}
