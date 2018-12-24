package timedifference;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DifferenceTypeDeterminedTest extends DifferenceTypeDetermined{

    @DisplayName("determineDifferenceTypeTest")
    @ParameterizedTest
    @CsvSource(value = {
            "0, ENOUGH",
            //leapYear
            "1, TIMELEFT",
            "-1, DEFICIT"
    })
    public void determineDifferenceTypeTest(int differenceinMinutes, DifferenceType differenceType){
        Assert.assertEquals(differenceType, DifferenceTypeDeterminedTest.determineDifferenceType(differenceinMinutes));

    }
}
