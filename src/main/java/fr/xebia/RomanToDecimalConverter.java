package fr.xebia;

public class RomanToDecimalConverter {
    public static int convert(String roman) {
        if ("".equals(roman)) {
            return 0;
        }
        return roman.chars().map(character -> RomanNumber.valueOf(Character.toString((char) character)).decimalValue()).sum();
    }
}
