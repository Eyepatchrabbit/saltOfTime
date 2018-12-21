package period;

import day.Day;
import day.DayFactory;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodFactory {

    public static Period weekBuilder(){
        return weekBuilder(LocalDate.now());
    }

    public static Period weekBuilder(LocalDate startDate){
        return basicPeriodBuilder(firstOfTheWeek(startDate), 7);
    }



    public static Period monthBuilder(){
        return monthBuilder(LocalDate.now());
    }

    public static Period monthBuilder(LocalDate startDate){
        return basicPeriodBuilder(startDate, numberOfDaysInMonth(startDate));
    }



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

    public static LocalDate firstOfTheWeek(LocalDate date) {
        return date.with(DayOfWeek.MONDAY);
    }

    public static int numberOfDaysInMonth(LocalDate date){
        return date.lengthOfMonth();
    }



}
