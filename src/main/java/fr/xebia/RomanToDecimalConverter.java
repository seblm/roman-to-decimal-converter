package fr.xebia;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RomanToDecimalConverter {
    public static int convert(String roman) {
        if ("".equals(roman)) {
            return 0;
        }
        int sum = 0;
        List<RomanNumber> romanNumbers = roman.chars().mapToObj(character -> RomanNumber.valueOf(Character.toString((char) character))).collect(toList());
        Collections.reverse(romanNumbers);
        RomanNumber previousRomanNumber = null;
        for (RomanNumber romanNumber : romanNumbers) {
            if (previousRomanNumber != null && romanNumber.shouldBeSubstractedIfBefore(previousRomanNumber)) {
                sum -= romanNumber.decimalValue();
            } else {
                sum += romanNumber.decimalValue();
            }
            previousRomanNumber = romanNumber;
        }
        return sum;
    }
}
