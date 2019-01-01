package periodreporting;

import inputhandeling.csvfilereader.CsvTimeReader;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import period.Period;
import period.PeriodFactory;
import timedifference.DifferenceType;
import utils.FindFolder;

import java.time.LocalDate;

import static java.lang.StrictMath.round;

public class PeriodReportingFactoryTest {

    @DisplayName("testingReportingWithData")
    @ParameterizedTest
    @CsvSource(value = {
            "/src/test/java/periodreporting/testingReportingOver.csv,25,TIMELEFT,5,0.7143,5,7",
            "/src/test/java/periodreporting/testingReportingOverBoundary.csv,1,TIMELEFT,5,0.7143,5,7",
            "/src/test/java/periodreporting/testingReportingUnderBoundary.csv,-1,DEFICIT,4,0.5714,5,7",
            "/src/test/java/periodreporting/testingReportingEnough.csv,0,ENOUGH,1,0.1429,5,7"
    })
    public void csvReadingTest(
            String testFileLocation,
            int expectedTotalTimeDiff,
            DifferenceType expectedDifferenceType,
            int expectedTotalDaysFilledIn,
            double expectedTotalDaysFilledInPercentage,
            int expectedTotalNumberWeekdays,
            int expectedotalDaysInPeriod
            ){
        String finalLocationTestFile= FindFolder.projectRootFolderLocation()+testFileLocation;

        Period period = CsvTimeReader.readingInput(finalLocationTestFile);

        Assert.assertEquals(expectedTotalTimeDiff, period.getPeriodReporting().getTotalTimeDifference());
        Assert.assertEquals(expectedDifferenceType, period.getPeriodReporting().getDifferenceType());
        Assert.assertEquals(expectedTotalDaysFilledIn, period.getPeriodReporting().getTotalDaysFilledIn());
        Assert.assertEquals(expectedTotalDaysFilledInPercentage, round( period.getPeriodReporting().getTotalDaysFilledInPercentage()),4);
        Assert.assertEquals(expectedTotalNumberWeekdays, period.getPeriodReporting().getTotalNumberWeekdays());
        Assert.assertEquals(expectedotalDaysInPeriod, period.getPeriodReporting().getTotalDaysInPeriod());


    }

    @DisplayName("testingReportingWithData")
    @Test
    public void noDataForReportingTest(){
        Period period= PeriodFactory.monthBuilder(LocalDate.of(2018,12,27));

        PeriodReporting periodReporting=PeriodReportingFactory.makeReportOfPeriod(period.getDaysInPeriod());

        Assert.assertEquals(0, periodReporting.getTotalTimeDifference());
        Assert.assertEquals(DifferenceType.ENOUGH, periodReporting.getDifferenceType());
        Assert.assertEquals(0, periodReporting.getTotalDaysFilledIn());
        Assert.assertEquals(0.0000, round( periodReporting.getTotalDaysFilledInPercentage()),4);
        Assert.assertEquals(21, periodReporting.getTotalNumberWeekdays());
        Assert.assertEquals(31, periodReporting.getTotalDaysInPeriod());

    }


}
