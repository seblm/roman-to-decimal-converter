package fr.xebia;

public enum RomanNumber {
    M(1000),
    D(500),
    C(100, D, M),
    L(50),
    X(10, L, C),
    V(5),
    I(1, V, X);

    private final int decimalValue;
    private final RomanNumber nextRomanNumbersImpliesSubstract;
    private final RomanNumber otherNextRomanNumbersImpliesSubstract;

    RomanNumber(int decimalValue) {
        this.decimalValue = decimalValue;
        this.nextRomanNumbersImpliesSubstract = null;
        this.otherNextRomanNumbersImpliesSubstract = null;
    }

    RomanNumber(int decimalValue, RomanNumber nextRomanNumbersImpliesSubstract, RomanNumber otherNextRomanNumbersImpliesSubstract) {
        this.decimalValue = decimalValue;
        this.nextRomanNumbersImpliesSubstract = nextRomanNumbersImpliesSubstract;
        this.otherNextRomanNumbersImpliesSubstract = otherNextRomanNumbersImpliesSubstract;
    }

    public int decimalValue() {
        return decimalValue;
    }

    public boolean shouldBeSubstractedIfBefore(RomanNumber nextRomanNumber) {
        return nextRomanNumber.equals(nextRomanNumbersImpliesSubstract) || nextRomanNumber.equals(otherNextRomanNumbersImpliesSubstract);
    }
}
