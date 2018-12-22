package day;

import timedifference.TimeDifference;

import java.security.PublicKey;
import java.time.LocalDate;

public class Day {

    private LocalDate date;

    private DayElements dayElements;

    private TimeDifference timeDifference;



    public Day(LocalDate date){
        setDate(date);

    }




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


    public TimeDifference getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(TimeDifference timeDifference) {
        this.timeDifference = timeDifference;
    }

}
