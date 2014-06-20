package fr.xebia;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptySet;

public enum RomanNumber {
    M(1000, true),
    D(500, false),
    C(100, true, D, M),
    L(50, false),
    X(10, true, L, C),
    V(5, false),
    I(1, true, V, X);

    private final int decimalValue;
    private final Set<RomanNumber> nextRomanNumbersImpliesSubstract;
    private final boolean shouldAdd;

    RomanNumber(int decimalValue, boolean shouldAdd) {
        this.shouldAdd = shouldAdd;
        this.decimalValue = decimalValue;
        this.nextRomanNumbersImpliesSubstract = emptySet();
    }

    RomanNumber(int decimalValue, boolean shouldAdd, RomanNumber firstRomanNumberImpliesSubstract, RomanNumber secondRomanNumberImpliesSubstract) {
        this.decimalValue = decimalValue;
        this.shouldAdd = shouldAdd;
        this.nextRomanNumbersImpliesSubstract = new HashSet<>();
        this.nextRomanNumbersImpliesSubstract.add(firstRomanNumberImpliesSubstract);
        this.nextRomanNumbersImpliesSubstract.add(secondRomanNumberImpliesSubstract);
    }

    public int decimalValue() {
        return decimalValue;
    }

    public boolean shouldBeSubstractedIfBefore(Optional<RomanNumber> nextRomanNumber) {
        if (!nextRomanNumber.isPresent()) {
            return false;
        }
        if (decimalValue >= nextRomanNumber.get().decimalValue) {
            return false;
        }
        boolean acceptToSubstract = nextRomanNumbersImpliesSubstract.contains(nextRomanNumber.get());
        if (!acceptToSubstract) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean shouldAdd() {
        return shouldAdd;
    }
}
