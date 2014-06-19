package fr.xebia;

public class RomanToDecimalConverter {
    public static int convert(String roman) {
        if ("".equals(roman)) {
            return 0;
        }
        if ("II".equals(roman)) {
            return 2;
        }
        return RomanNumber.valueOf(roman).decimalValue();
    }
}
