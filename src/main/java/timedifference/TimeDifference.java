package timedifference;

public class TimeDifference {

    //In minutes or possibly better in seconds ?? or make it variable later in settings
    private int timeDifference;

    private DifferenceType differenceType=DifferenceType.UNKNOWN;


    public void setTimeDifference(int timeDifference) {
        this.timeDifference = timeDifference;
    }

    public int getTimeDifference() {
        return timeDifference;
    }



    public void setDifferenceType(DifferenceType differenceType) {
        this.differenceType = differenceType;
    }

    public DifferenceType getDifferenceType() {
        return differenceType;
    }





}