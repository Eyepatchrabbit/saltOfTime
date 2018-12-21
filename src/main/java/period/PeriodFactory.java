package period;

import day.Day;
import day.DayFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodFactory {

    public static Period basicPeriodBuilder(LocalDate startDate, int periodlength) {

        Period periodToBuild=new Period();

        periodToBuild.setStartOfPeriod(startDate);

        periodToBuild.setPeriodLength(periodlength);

        periodToBuild.setDaysInPeriod(makeListDaysInPeriod( startDate, periodlength));


        return periodToBuild;

    }


    public static List<Day> makeListDaysInPeriod(LocalDate startDate, int periodlength) {
        //start list
        List<Day> listOfDays=new ArrayList();

        //add days in the period
        LocalDate dayToAddDate=startDate;

        for (int nrDay=0;nrDay<periodlength;nrDay++){
            Day dayToAdd= DayFactory.basicDayFacory(dayToAddDate);
            listOfDays.add(dayToAdd);

            dayToAddDate= dayToAddDate.plusDays(1);
        }

        //sort list based on date


        //return
        return listOfDays;

    }

}
