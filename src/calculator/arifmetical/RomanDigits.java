package calculator.arifmetical;

public enum RomanDigits {
    I (1),
    V (5),
    X (10),
    L (50),
    C (100),
    D (500),    // JUST FOR TESTS!
    M (1000);   // JUST FOR TESTS!

    private final int index;

    RomanDigits(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }

    static public int indexOf(char digit) {
        return valueOf(String.valueOf(digit)).index();
    }

    static public RomanDigits nameOf(int index) {
        for (RomanDigits digit : RomanDigits.values()) {
            if (digit.index() == index) {
                return digit;
            }
        }
        return null;
    }
}
