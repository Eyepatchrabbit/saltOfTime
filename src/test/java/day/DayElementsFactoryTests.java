package day;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static day.DayElementsFactory.weekDayType;
import static day.DayElementsFactory.weekName;

public class DayElementsFactoryTests {

    @DisplayName("seeIfDayOfTheWeekNameCorrect")
    @ParameterizedTest
    @CsvSource(value = {"Saturday, 2018:08:04", "Sunday, 2017:09:10","Monday, 2017:11:13","Tuesday, 2019:01:01","Wednesday, 2018:10:31","Thursday, 2017:11:02","Friday, 2018:09:28"})
    public void testDayOfTheWeekName(String expectedDayName, String dateToDetermineName) {
        Locale locale = Locale.US;
        LocalDate dateFormattedToProcess=LocalDate.of(Integer.parseInt(dateToDetermineName.split(":")[0]),Integer.parseInt(dateToDetermineName.split(":")[1]),Integer.parseInt(dateToDetermineName.split(":")[2]));
        Assert.assertEquals( expectedDayName,  weekName(dateFormattedToProcess).getDisplayName(TextStyle.FULL,locale));
    }

    @DisplayName("seeIfDayOfTheWeekNameCorrect")
    @ParameterizedTest
    @CsvSource(value = {"WEEKEND, 2018:08:04", "WEEKEND, 2017:09:10","WEEKDAY, 2017:11:13","WEEKDAY, 2019:01:01","WEEKDAY, 2018:10:31","WEEKDAY, 2017:11:02","WEEKDAY, 2018:09:28"})
    public void testWeekDayType( String weekdayType, String dateToDetermineName) {
        WeekDayType weekDayTypeInTest= weekdayType.equals("WEEKDAY") ? WeekDayType.WEEKDAY : WeekDayType.WEEKEND;

        LocalDate dateFormattedToProcess=LocalDate.of(Integer.parseInt(dateToDetermineName.split(":")[0]),Integer.parseInt(dateToDetermineName.split(":")[1]),Integer.parseInt(dateToDetermineName.split(":")[2]));

        DayOfWeek dayOfWeek= dateFormattedToProcess.getDayOfWeek();

        Assert.assertTrue(weekDayTypeInTest.equals(weekDayType(dayOfWeek)));
    }


}
