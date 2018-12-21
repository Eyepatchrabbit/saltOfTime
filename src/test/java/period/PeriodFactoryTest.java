package period;

import day.Day;
import day.WeekDayType;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PeriodFactoryTest {

    @DisplayName("smoketestPeriodbuilderOneDay")
    @Test
    public void basicPeriodBuilder_OneDayTest() {
        //make "period" of 1 day->see if the needed elements were made
        Period period= PeriodFactory.basicPeriodBuilder(LocalDate.of(2018,12, 1),1);

        //basic elements of the period
        Assert.assertEquals(LocalDate.of(2018,12,1),period.getStartOfPeriod());
        Assert.assertEquals(1,period.getPeriodLength());
        Assert.assertEquals(1,period.getDaysInPeriod().size());

        //see if elements of the day are good
        Day day=period.getDaysInPeriod().get(0);

        Assert.assertEquals(LocalDate.of(2018,12,1),day.getDate());


        //see if the elements of the dayelements are correctly set
        Assert.assertEquals(DayOfWeek.SATURDAY,day.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,day.getDayElements().getWeekDayType());

    }

    @DisplayName("smoketestPeriodbuilderTwoDays")
    @Test
    public void basicPeriodBuilder_TwoDayTest() {
        //make "period" of 1 day->see if the needed elements were made
        Period period= PeriodFactory.basicPeriodBuilder(LocalDate.of(2018,12, 1),2);

        //basic elements of the period
        Assert.assertEquals(LocalDate.of(2018,12,1),period.getStartOfPeriod());
        Assert.assertEquals(2,period.getPeriodLength());
        Assert.assertEquals(2,period.getDaysInPeriod().size());

        //first day in period
        Day dayOne=period.getDayFromPeriod(LocalDate.of(2018,12,1));

        Assert.assertEquals(LocalDate.of(2018,12,1),dayOne.getDate());

        Assert.assertEquals(DayOfWeek.SATURDAY,dayOne.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,dayOne.getDayElements().getWeekDayType());

        //second day in period
        Day dayTwo=period.getDayFromPeriod(LocalDate.of(2018,12,2));

        Assert.assertEquals(LocalDate.of(2018,12,2),dayTwo.getDate());

        Assert.assertEquals(DayOfWeek.SUNDAY,dayTwo.getDayElements().getWeekName());
        Assert.assertEquals(WeekDayType.WEEKEND,dayTwo.getDayElements().getWeekDayType());

    }
}
