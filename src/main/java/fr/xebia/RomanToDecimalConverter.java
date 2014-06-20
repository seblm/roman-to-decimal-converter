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
            consecutiveRomanNumbers = checkConsecutiveRomanNumbers(consecutiveRomanNumbers, previousRomanNumber, romanNumber);
            int sign = romanNumber.shouldBeSubstractedIfBefore(previousRomanNumber) ? -1 : 1;
            sum += sign * romanNumber.decimalValue();
            previousRomanNumber = of(romanNumber);
        }
        return sum;
    }

    private static int checkConsecutiveRomanNumbers(int consecutiveRomanNumbers, Optional<RomanNumber> previousRomanNumber, RomanNumber romanNumber) throws IllegalArgumentException {
        if (!previousRomanNumber.isPresent()) {
            return 0;
        }
        boolean isConsecutive = previousRomanNumber.get().equals(romanNumber);
        if (!isConsecutive) {
            return 0;
        }
        if (!romanNumber.shouldAdd()) {
            throw new IllegalArgumentException();
        }
        int newConsecutiveRomanNumbers = consecutiveRomanNumbers + 1;
        if (newConsecutiveRomanNumbers >= 3) {
            throw new IllegalArgumentException();
        }
        return newConsecutiveRomanNumbers;
    }
}
