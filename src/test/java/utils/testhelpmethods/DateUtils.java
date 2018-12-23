package utils.testhelpmethods;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate stringToLocalDate(String inputDate) {
        return LocalDate.of(Integer.parseInt(inputDate.split(":")[0]),Integer.parseInt(inputDate.split(":")[1]),Integer.parseInt(inputDate.split(":")[2]));
    }
}
