package timedifference;

public class DifferenceTypeDetermined {
    public static DifferenceType determineDifferenceType(int timeDifferenceInDay){
        if (timeDifferenceInDay>=0){
            if (timeDifferenceInDay>0){
                return DifferenceType.TIMELEFT;
            }
            return DifferenceType.ENOUGH;
        }

        return DifferenceType.DEFICIT;

    }
}
