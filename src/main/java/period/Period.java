package period;

import day.Day;
import periodreporting.PeriodReporting;

import java.time.LocalDate;
import java.util.List;

public class Period {

    private PeriodType periodType;

    private LocalDate startOfPeriod;

    private int periodLength;

    private List<Day> daysInPeriod;

    private PeriodReporting periodReporting;



    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }


    public void setStartOfPeriod(LocalDate startOfPeriod) {
        this.startOfPeriod = startOfPeriod;
    }

    public LocalDate getStartOfPeriod() {
        return startOfPeriod;
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



    public void setPeriodReporting(PeriodReporting periodReporting) {
        this.periodReporting = periodReporting;
    }

    public PeriodReporting getPeriodReporting() {
        return periodReporting;
    }


}
