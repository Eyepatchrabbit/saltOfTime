package timedifference;

public class TimeDifference {

    //In minutes or possibly better in seconds ?? or make it variable later in settings
    private int timeDifferenceInputted;

    private DifferenceType differenceType;


    public void setTimeDifferenceInputted(int timeDifferenceInputted) {
        this.timeDifferenceInputted = timeDifferenceInputted;
    }

    public int getTimeDifferenceInputted() {
        return timeDifferenceInputted;
    }



    public void setDifferenceType(DifferenceType differenceType) {
        this.differenceType = differenceType;
    }

    public DifferenceType getDifferenceType() {
        return differenceType;
    }

}