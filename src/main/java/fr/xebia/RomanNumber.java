package fr.xebia;

public enum RomanNumber {
    I(1),
    V(5);
    private final int decimalValue;

    RomanNumber(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public int decimalValue() {
        return decimalValue;
    }
}
