package fr.xebia;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptySet;

public enum RomanNumber {
    M(1000),
    D(500),
    C(100, D, M),
    L(50),
    X(10, L, C),
    V(5),
    I(1, V, X);

    private final int decimalValue;
    private final Set<RomanNumber> nextRomanNumbersImpliesSubstract;

    RomanNumber(int decimalValue) {
        this.decimalValue = decimalValue;
        this.nextRomanNumbersImpliesSubstract = emptySet();
    }

    RomanNumber(int decimalValue, RomanNumber firstRomanNumberImpliesSubstract, RomanNumber secondRomanNumberImpliesSubstract) {
        this.decimalValue = decimalValue;
        this.nextRomanNumbersImpliesSubstract = new HashSet<>();
        this.nextRomanNumbersImpliesSubstract.add(firstRomanNumberImpliesSubstract);
        this.nextRomanNumbersImpliesSubstract.add(secondRomanNumberImpliesSubstract);
    }

    public int decimalValue() {
        return decimalValue;
    }

    public boolean shouldBeSubstractedIfBefore(Optional<RomanNumber> nextRomanNumber) {
        return nextRomanNumber.isPresent() && nextRomanNumbersImpliesSubstract.contains(nextRomanNumber.get());
    }
}
