package timedifference;

import day.Day;
import period.Period;

import java.time.LocalDate;
import java.util.List;

import static period.PeriodFactory.dayLocationInlist;
import static timedifference.TimeDifferenceFactory.timeDifferenceBuilder;

public class TimePLacer {

    /*
    public static Period inputTimeDifferenceInPeriod ( Period period ,LocalDate dateToAddTimeTo, int timeDifferenceToAdd){
        Period periodAdapted=period;
        period.setDaysInPeriod( inputTimeDifference(period.getDaysInPeriod(),dateToAddTimeTo,timeDifferenceToAdd));
        return periodAdapted;

    }
    */

    public static List<Day> inputTimeDifference(List<Day> daylist, LocalDate dateToAddTimeTo, int timeDifferenceToAdd){
        List<Day> adaptedList=daylist;

        try {
            //see if in
            int dayLocatorInList=seeIfDateInGivenDayeList(daylist,dateToAddTimeTo);

            Day updatedDay= daylist.get(dayLocatorInList);
            updatedDay.setTimeDifference(timeDifferenceBuilder(timeDifferenceToAdd));

            adaptedList.set(dayLocatorInList,updatedDay);


        } catch (Exception exception){
            
            exception.printStackTrace();
        }

        return adaptedList;

    }


    private static int seeIfDateInGivenDayeList(List<Day> daylist, LocalDate dateToAddTimeTo){
        int dayLocator=dayLocationInlist(daylist,dateToAddTimeTo);
        if (dayLocator<0){
            throw new IllegalArgumentException();
        }
        return dayLocator;
    }



}
