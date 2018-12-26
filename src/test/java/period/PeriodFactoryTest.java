package period;

import day.Day;
import day.WeekDayType;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.testhelpmethods.DateUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static period.PeriodFactory.*;

public class PeriodFactoryTest {

    @DisplayName("smoketestPeriodbuilderOneDay")
    @Test
    public void basicPeriodBuilder_OneDayTest() {
        //make "period" of 1 day->see if the needed elements were made
        Period period= PeriodFactory.basicPeriodBuilder(LocalDate.of(2018,12, 1),1,PeriodType.ELSE);

        //basic elements of the period
        Assert.assertEquals(PeriodType.ELSE,period.getPeriodType());
        Assert.assertEquals(LocalDate.of(2018,12,1),period.getStartOfPeriod());
        Assert.assertEquals(1,period.getPeriodLength());
        Assert.assertEquals(1,period.getDaysInPeriod().size());

        //see if elements of the day are good
        Day day=period.getDaysInPeriod().get(0);

        Assert.assertEquals(LocalDate.of(2018,12,1),day.getDate());


        //see if the elements of the dayelements are correctly set
        Assert.assertEquals(DayOfWeek.SATURDAY,day.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,day.getDayElements().getWeekDayType());

        //see elements if TimeDifference aren't set yet
        Assert.assertEquals(null,day.getTimeDifference());

    }

    @DisplayName("smoketestPeriodbuilderTwoDays")
    @Test
    public void basicPeriodBuilder_TwoDayTest() {
        //make "period" of 1 day->see if the needed elements were made
        Period period= PeriodFactory.basicPeriodBuilder(LocalDate.of(2018,12, 1),2,PeriodType.ELSE);

        //basic elements of the period
        Assert.assertEquals(PeriodType.ELSE,period.getPeriodType());
        Assert.assertEquals(LocalDate.of(2018,12,1),period.getStartOfPeriod());
        Assert.assertEquals(2,period.getPeriodLength());
        Assert.assertEquals(2,period.getDaysInPeriod().size());

        //first day in period
        Day dayOne=period.getDayFromPeriod(LocalDate.of(2018,12,1));

        Assert.assertEquals(LocalDate.of(2018,12,1),dayOne.getDate());

        Assert.assertEquals(DayOfWeek.SATURDAY,dayOne.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,dayOne.getDayElements().getWeekDayType());

        Assert.assertEquals(null,dayOne.getTimeDifference());

        //second day in period
        Day dayTwo=period.getDayFromPeriod(LocalDate.of(2018,12,2));

        Assert.assertEquals(LocalDate.of(2018,12,2),dayTwo.getDate());

        Assert.assertEquals(DayOfWeek.SUNDAY,dayTwo.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,dayTwo.getDayElements().getWeekDayType());

        Assert.assertEquals(null,dayTwo.getTimeDifference());

    }

    @DisplayName("firstOfTheWeek")
    @ParameterizedTest
    @CsvSource(value = {
            //default
            "2018:12:21, 2018:12:17",
            //when inputdate is the first of the week
            "2018:12:17, 2018:12:17",
            //is in a previous month
            "2018:12:01, 2018:11:26",
            //next day is a monday
            "2018:12:23, 2018:12:17"
    })
    public void firstOfTheWeekTest(String StartDate,String ExpectedFirstMonday){
        Assert.assertEquals( firstOfTheWeek(DateUtils.stringToLocalDate(StartDate)), DateUtils.stringToLocalDate(ExpectedFirstMonday));
    }

    @DisplayName("numberOfDayOfMonth")
    @ParameterizedTest
    @CsvSource(value = {
            "2018:12:23, 31",
            //leapYear
            "2000:02:23, 29",
            "2001:02:23, 28"
    })
    public void numberOfDaysInMonthTest(String date, String expectedNumberOfDays){
        Assert.assertTrue(numberOfDaysInMonth(DateUtils.stringToLocalDate(date))==Integer.parseInt(expectedNumberOfDays));

    }


    @DisplayName("dayLocationInlistTest")
    @ParameterizedTest
    @CsvSource(value = {
            //first day
            "2018:12:17,2018:12:17,0",
            //second day
            "2018:12:17,2018:12:18,1",
            //last day period
            "2018:12:17,2018:12:23,6",
            //Before period
            "2018:12:17,2018:12:16,-1",
            //next monday
            "2018:12:17,2018:12:24,-1"
    })
    public void dayLocationInlistTest(String startOfPeriod,String dayToFindInList,int expectedOutput){
        Period weekPeriod= weekBuilder(DateUtils.stringToLocalDate(startOfPeriod));
        int daylocationFromMethod=dayLocationInlist(weekPeriod.getDaysInPeriod(),DateUtils.stringToLocalDate(dayToFindInList));
        Assert.assertEquals(expectedOutput, daylocationFromMethod);
    }


    @DisplayName("smokeTestingWeekBuilder")
    @Test
    public void buidlingWeekTest(){
        Period period=weekBuilder(LocalDate.of(2018,12,26));

        Assert.assertEquals(LocalDate.of(2018,12,24),period.getStartOfPeriod());
        Assert.assertEquals(7,period.getDaysInPeriod().size());
        Assert.assertEquals(7,period.getPeriodLength());
        Assert.assertEquals(PeriodType.WEEK,period.getPeriodType());


        List<Day> daysList=period.getDaysInPeriod();
        Assert.assertEquals(0,dayLocationInlist(daysList,LocalDate.of(2018,12,24)));
        Assert.assertEquals(2,dayLocationInlist(daysList,LocalDate.of(2018,12,26)));
        Assert.assertEquals(6,dayLocationInlist(daysList,LocalDate.of(2018,12,30)));

    }

    @DisplayName("smokeTestingMonthBuilder")
    @Test
    public void buidlingMonthTest(){
        Period period=monthBuilder(LocalDate.of(2018,12,26));

        Assert.assertEquals(LocalDate.of(2018,12,1),period.getStartOfPeriod());
        Assert.assertEquals(31,period.getDaysInPeriod().size());
        Assert.assertEquals(31,period.getPeriodLength());
        Assert.assertEquals(PeriodType.MONTH,period.getPeriodType());


        List<Day> daysList=period.getDaysInPeriod();
        Assert.assertEquals(0,dayLocationInlist(daysList,LocalDate.of(2018,12,1)));
        Assert.assertEquals(23,dayLocationInlist(daysList,LocalDate.of(2018,12,24)));
        Assert.assertEquals(25,dayLocationInlist(daysList,LocalDate.of(2018,12,26)));
        Assert.assertEquals(29,dayLocationInlist(daysList,LocalDate.of(2018,12,30)));
        Assert.assertEquals(30,dayLocationInlist(daysList,LocalDate.of(2018,12,31)));

    }


}
