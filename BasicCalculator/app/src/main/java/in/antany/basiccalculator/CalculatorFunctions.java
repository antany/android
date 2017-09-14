package in.antany.basiccalculator;

import java.math.BigDecimal;

/**
 * Created by antany on 22/07/16.
 */
public class CalculatorFunctions {
    public static String typeNumber(String current, String typed){
        BigDecimal ten = new BigDecimal("10");
        BigDecimal currValue = new BigDecimal(current);
        BigDecimal typeValue = new BigDecimal(typed);
        currValue = currValue.multiply(ten);
        currValue = currValue.add(typeValue);
        return currValue.toPlainString();
    }
}
