package day;

import java.time.LocalDate;

public class Day {

    private LocalDate date;


    private DayElements dayElements;


    public void setDate(LocalDate date) {
        this.date = date;
    }


    public LocalDate getDate() {
        return date;
    }


    public DayElements getDayElements() {
        return dayElements;
    }

    public void setDayElements(DayElements dayElements) {
        this.dayElements = dayElements;
    }



}
