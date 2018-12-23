package timedifference;

import day.Day;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import period.Period;
import period.PeriodFactory;

import java.time.LocalDate;

import static timedifference.TimePLacer.inputTimeDifference;

public class TimePlacerTest {

    @DisplayName("inputTimeDifferenceTest")
    @Test
    public void inputTimeDifferenceTest() {
        //make "period" of 1 day->see if the needed elements were made
        Period period= PeriodFactory.weekBuilder(LocalDate.of(2018,12, 19));

        //basic elements of the period
        Assert.assertEquals(LocalDate.of(2018,12,17),period.getStartOfPeriod());
        Assert.assertEquals(7,period.getPeriodLength());
        Assert.assertEquals(7,period.getDaysInPeriod().size());

        for (Day investigateDay: period.getDaysInPeriod() ) {
            Assert.assertEquals(null, investigateDay.getTimeDifference());
        }

        period.setDaysInPeriod( inputTimeDifference(period.getDaysInPeriod(),LocalDate.of(2018,12,19),60));

        for (Day investigateDay: period.getDaysInPeriod() ) {
            if (!investigateDay.getDate().equals(LocalDate.of(2018,12,19))){
                Assert.assertEquals(null, investigateDay.getTimeDifference());
            }else {
                Assert.assertEquals(60, investigateDay.getTimeDifference().getTimeDifferenceInputted());
                Assert.assertEquals(DifferenceType.TIMELEFT, investigateDay.getTimeDifference().getDifferenceType());
            }
        }

    }
}
