package utils;


import java.math.BigDecimal;

import static java.lang.Math.round;

public class RoundingDoubleValue {

    public static double roundDoubleToFourDigits (double inputDouble){
        return BigDecimal.valueOf(inputDouble).setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
