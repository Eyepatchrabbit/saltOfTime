package period;

import day.Day;

import java.time.LocalDate;
import java.util.List;

public class Period {

    private LocalDate startPeriod;

    private int periodLength;

    private List<Day> daysInPeriod;






    public void setStartPeriod(LocalDate startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDate getStartPeriod() {
        return startPeriod;
    }


    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public int getPeriodLength() {
        return periodLength;
    }



    public void setDaysInPeriod(List<Day> daysInPeriod) {
        this.daysInPeriod = daysInPeriod;
    }

    public List<Day> getDaysInPeriod() {
        return daysInPeriod;
    }


    public Day getDayFromPeriod(LocalDate date){
        for (Day dayInList:daysInPeriod) {
            if (dayInList.getDate().equals(date)){
                return dayInList;
            }
        }
        return null;
    }


}
