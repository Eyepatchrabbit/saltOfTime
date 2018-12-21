package day.timedifference;

import org.apache.commons.lang3.builder.Diff;

import java.time.LocalTime;

public class TimeDifferenceFactory {

    public static TimeDifference timeDifferenceBuilder(int timeDifferenceInDay){
        TimeDifference timeDifference=new TimeDifference();

        timeDifference.setTimedifference(timeDifferenceInDay);

        timeDifference.setDifferenceType(determineDifferenceType(timeDifferenceInDay));

        return timeDifference;
    }
    


    protected static DifferenceType determineDifferenceType(int timeDifferenceInDay){
        if (timeDifferenceInDay>=0){
            if (timeDifferenceInDay>0){
                return DifferenceType.TIMELEFT;
            }
            return DifferenceType.ENOUGH;
        }

        return DifferenceType.DEFICIT;

    }

}
