package periodreporting;

import inputreading.csvfilereader.CsvTimeReader;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import period.Period;
import timedifference.DifferenceType;
import utils.FindFolder;

import static java.lang.StrictMath.round;

public class PeriodReportingFactoryTest {

    @DisplayName("testingReporting_TimeOver")
    @ParameterizedTest
    @CsvSource(value = {"/src/test/java/periodreporting/testingReportingOver.csv"})
    public void csvReadingTest(String testFileLocation){
        String finalLocationTestFile= FindFolder.projectRootFolderLocation()+testFileLocation;

        Period period = CsvTimeReader.readingInput(finalLocationTestFile);

        Assert.assertEquals(25, period.getPeriodReporting().getTotalTimeDifference());
        Assert.assertEquals(DifferenceType.TIMELEFT, period.getPeriodReporting().getDifferenceType());
        Assert.assertEquals(5, period.getPeriodReporting().getTotalDaysFilledIn());
        Assert.assertEquals(0.7143, round( period.getPeriodReporting().getTotalDaysFilledInPercentage()),4);
        Assert.assertEquals(5, period.getPeriodReporting().getTotalNumberWeekdays());
        Assert.assertEquals(7, period.getPeriodReporting().getTotalDaysInPeriod());


    }


}
