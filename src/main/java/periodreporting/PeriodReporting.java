package periodreporting;

import timedifference.DifferenceType;

public class PeriodReporting {
    private int totalTimeDifference;

    private DifferenceType differenceType;

    private int totalDaysFilledIn;

    private double totalDaysFilledInPercentage;

    private int totalNumberWeekdays;

    private int totalDaysInPeriod;


    public int getTotalTimeDifference() {
        return totalTimeDifference;
    }

    public void setTotalTimeDifference(int totalTimeDifference) {
        this.totalTimeDifference = totalTimeDifference;
    }


    public DifferenceType getDifferenceType() {
        return differenceType;
    }

    public void setDifferenceType(DifferenceType differenceType) {
        this.differenceType = differenceType;
    }



    public int getTotalDaysFilledIn() {
        return totalDaysFilledIn;
    }

    public void setTotalDaysFilledIn(int totalDaysFilledIn) {
        this.totalDaysFilledIn = totalDaysFilledIn;
    }


    public double getTotalDaysFilledInPercentage() {
        return totalDaysFilledInPercentage;
    }

    public void setTotalDaysFilledInPercentage(double totalDaysFilledInPercentage) {
        this.totalDaysFilledInPercentage = totalDaysFilledInPercentage;
    }

    public int getTotalNumberWeekdays() {
        return totalNumberWeekdays;
    }

    public void setTotalNumberWeekdays(int totalNumberWeekdays) {
        this.totalNumberWeekdays = totalNumberWeekdays;
    }


    public int getTotalDaysInPeriod() {
        return totalDaysInPeriod;
    }

    public void setTotalDaysInPeriod(int totalDaysInPeriod) {
        this.totalDaysInPeriod = totalDaysInPeriod;
    }
}
