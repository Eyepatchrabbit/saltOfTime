package day.timedifference;

import java.time.LocalTime;

public class TimeDifference {

    private int timedifference;

    private DifferenceType differenceType=DifferenceType.UNKNOWN;


    public void setTimedifference(int timedifference) {
        this.timedifference = timedifference;
    }

    public int getTimedifference() {
        return timedifference;
    }



    public void setDifferenceType(DifferenceType differenceType) {
        this.differenceType = differenceType;
    }

    public DifferenceType getDifferenceType() {
        return differenceType;
    }





}