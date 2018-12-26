package inputhandeling.csvfilereader;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import period.Period;
import timedifference.DifferenceType;
import utils.FindFolder;

import java.time.LocalDate;

public class CsvTimeReaderTest {

    @DisplayName("csvReadingTest")
    @ParameterizedTest
    @CsvSource(value = {"/src/test/java/inputhandeling/csvfilereader/testCsvFile.csv"})
    public void csvReadingTest(String inputFileLocation){
        String finalLocationTestFile= FindFolder.projectRootFolderLocation()+inputFileLocation;

        Period period =CsvTimeReader.readingInput(finalLocationTestFile);

        Assert.assertEquals(10,period.getDayFromPeriod(LocalDate.of(2018,12,17)).getTimeDifference().getTimeDifferenceInputted());
        Assert.assertEquals(DifferenceType.TIMELEFT,period.getDayFromPeriod(LocalDate.of(2018,12,17)).getTimeDifference().getDifferenceType());

        Assert.assertEquals(null,period.getDayFromPeriod(LocalDate.of(2018,12,18)).getTimeDifference());

        Assert.assertEquals(8,period.getDayFromPeriod(LocalDate.of(2018,12,19)).getTimeDifference().getTimeDifferenceInputted());
        Assert.assertEquals(DifferenceType.TIMELEFT,period.getDayFromPeriod(LocalDate.of(2018,12,19)).getTimeDifference().getDifferenceType());

        Assert.assertEquals(-1,period.getDayFromPeriod(LocalDate.of(2018,12,20)).getTimeDifference().getTimeDifferenceInputted());
        Assert.assertEquals(DifferenceType.DEFICIT,period.getDayFromPeriod(LocalDate.of(2018,12,20)).getTimeDifference().getDifferenceType());

        Assert.assertEquals(null,period.getDayFromPeriod(LocalDate.of(2018,12,21)).getTimeDifference());

        Assert.assertEquals(null,period.getDayFromPeriod(LocalDate.of(2018,12,22)).getTimeDifference());

        Assert.assertEquals(0,period.getDayFromPeriod(LocalDate.of(2018,12,23)).getTimeDifference().getTimeDifferenceInputted());
        Assert.assertEquals(DifferenceType.ENOUGH,period.getDayFromPeriod(LocalDate.of(2018,12,23)).getTimeDifference().getDifferenceType());

    }

}
