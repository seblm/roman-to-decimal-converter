package fr.xebia;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RomanToDecimalConverter {
    public static int convert(String roman) {
        if ("".equals(roman)) {
            return 0;
        }

        List<RomanNumber> romanNumbers = readRomanNumbersInReverseOrder(roman);

        return convert(romanNumbers);
    }

    private static List<RomanNumber> readRomanNumbersInReverseOrder(String roman) {
        List<RomanNumber> romanNumbers = roman.chars()
            .mapToObj(character -> RomanNumber.valueOf(Character.toString((char) character)))
            .collect(toList());
        Collections.reverse(romanNumbers);
        return romanNumbers;
    }

    private static int convert(List<RomanNumber> romanNumbers) {
        int sum = 0;
        Optional<RomanNumber> previousRomanNumber = empty();
        int consecutiveRomanNumbers = 0;
        for (RomanNumber romanNumber : romanNumbers) {
            if (previousRomanNumber.isPresent()) {
                consecutiveRomanNumbers = previousRomanNumber.get().equals(romanNumber) ? consecutiveRomanNumbers + 1 : 0;
                if (consecutiveRomanNumbers >= 3) {
                    throw new IllegalArgumentException();
                }
            }
            int sign = romanNumber.shouldBeSubstractedIfBefore(previousRomanNumber) ? -1 : 1;
            sum += sign * romanNumber.decimalValue();
            previousRomanNumber = of(romanNumber);
        }
        return sum;
    }
}
