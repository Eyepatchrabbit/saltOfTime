package periodreporting;

import day.Day;
import day.WeekDayType;
import timedifference.DifferenceTypeDetermined;

import java.util.List;

public class PeriodReportingFactory {

    public static PeriodReporting makeReportOfPeriod(List<Day> daylistPeriod){
        PeriodReporting periodReporting=new PeriodReporting();

        int totalTimeDifference = 0;
        int totalDaysFilledIn = 0;
        int totalNumberWeekdays = 0;
        int totalNumberWeekdaysFilledIn = 0;

        int totalDaysInPeriod=daylistPeriod.size();

        for (Day dayInPeriod:daylistPeriod) {
            if (dayInPeriod.getTimeDifference()!=(null)){
                totalTimeDifference=totalTimeDifference+dayInPeriod.getTimeDifference().getTimeDifferenceInputted();

                totalDaysFilledIn++;

                if (dayInPeriod.getDayElements().getWeekDayType().equals(WeekDayType.WEEKDAY)){
                    totalNumberWeekdaysFilledIn++;
                }

            }
            if (dayInPeriod.getDayElements().getWeekDayType().equals(WeekDayType.WEEKDAY)){
                totalNumberWeekdays++;
            }
        }

        periodReporting.setTotalTimeDifference(totalTimeDifference);
        periodReporting.setDifferenceType(DifferenceTypeDetermined.determineDifferenceType(totalTimeDifference));
        periodReporting.setTotalDaysInPeriod(totalDaysInPeriod);
        periodReporting.setTotalDaysFilledIn(totalDaysFilledIn);
        periodReporting.setTotalDaysFilledInPercentage(totalDaysFilledIn >0 ? ( ( (double) totalDaysFilledIn)/totalDaysInPeriod) : 0);
        periodReporting.setTotalNumberWeekdays(totalNumberWeekdays);
        periodReporting.setTotalWeekDaysFilledIn(totalNumberWeekdaysFilledIn);
        periodReporting.setTotalWeekDaysFilledInPercentage(totalNumberWeekdaysFilledIn >0 ? ( ( (double) totalNumberWeekdaysFilledIn)/totalNumberWeekdays) : 0);


        return periodReporting;
    }

}
