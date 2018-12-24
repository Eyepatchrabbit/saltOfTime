package timedifference;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TimeDifferenceFactoryTest extends TimeDifferenceFactory{

    @DisplayName("timeDifferenceBuilderTest")
    @ParameterizedTest
    @CsvSource(value = {
            "0, ENOUGH",
            //leapYear
            "1, TIMELEFT",
            "-1, DEFICIT"
    })
    public void timeDifferenceBuilderTest(int differenceinMinutes, DifferenceType differenceType){
        TimeDifference timeDifference= timeDifferenceBuilder(differenceinMinutes);

        Assert.assertEquals(differenceType,timeDifference.getDifferenceType());
        Assert.assertEquals(differenceinMinutes,timeDifference.getTimeDifferenceInputted());

    }


}
