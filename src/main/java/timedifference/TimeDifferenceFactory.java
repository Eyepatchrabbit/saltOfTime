package timedifference;

public class TimeDifferenceFactory {

    public static TimeDifference timeDifferenceBuilder(int timeDifferenceInDay){
        TimeDifference timeDifference=new TimeDifference();

        timeDifference.setTimeDifferenceInputted(timeDifferenceInDay);

        timeDifference.setDifferenceType(DifferenceTypeDetermined.determineDifferenceType(timeDifferenceInDay));

        return timeDifference;
    }


}
