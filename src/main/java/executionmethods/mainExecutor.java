package executionmethods;

import period.Period;
import period.PeriodFactory;

import java.time.LocalDate;

public class mainExecutor {

    public static void manualTestSetup() {
        Period period= PeriodFactory.basicPeriodBuilder(LocalDate.of(2018,12, 1),1);

        System.out.println("see what we get");
    }
}
