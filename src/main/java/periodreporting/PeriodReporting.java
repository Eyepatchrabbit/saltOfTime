package periodreporting;

import timedifference.DifferenceType;

public class PeriodReporting {
    int totalTimeDifference;

    int totalDaysFilledIn;

    int totalNumberWeekdays;

    DifferenceType differenceType;


    public int getTotalTimeDifference() {
        return totalTimeDifference;
    }

    public void setTotalTimeDifference(int totalTimeDifference) {
        this.totalTimeDifference = totalTimeDifference;
    }

    public int getTotalDaysFilledIn() {
        return totalDaysFilledIn;
    }

    public void setTotalDaysFilledIn(int totalDaysFilledIn) {
        this.totalDaysFilledIn = totalDaysFilledIn;
    }

    public int getTotalNumberWeekdays() {
        return totalNumberWeekdays;
    }

    public void setTotalNumberWeekdays(int totalNumberWeekdays) {
        this.totalNumberWeekdays = totalNumberWeekdays;
    }
}
