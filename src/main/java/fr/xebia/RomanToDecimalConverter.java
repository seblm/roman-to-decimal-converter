package fr.xebia;

public class RomanToDecimalConverter {
    public static int convert(String roman) {
        if ("I".equals(roman)) {
            return 1;
        }
        if ("V".equals(roman)) {
            return 5;
        }
        return 0;
    }
}
