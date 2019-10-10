package calculations.arifmetical;

class NumberConverter {
    int RomanToArabic(String number) {
        int result = 0;
        int prev = 0;
        for (int i=number.length(); i>0; i--) {
            int value = RomanDigits.indexOf(number.charAt(i-1));
            if (prev > value) {
                result -= value;
            } else {
                result += value;
            }
            prev = value;
        }
        return result;
    }

    String ArabicToRoman(int number) {
        StringBuilder result = new StringBuilder();
        String digits = String.valueOf(number);
        int count = digits.length();
        for (int i=1; i<=count; i++) {
            int d = (int) Math.pow(10,count-i);
            int n = Character.getNumericValue(digits.charAt(i-1));
            if (n > 0) {
                int f = 5*d;
                if (n == 5) {
                    result.append(RomanDigits.valueOf(f));
                } else {
                    int p = f;
                    if (n > 5) {
                        n = n-5;
                        p = d*10;
                    }
                    if (n == 4) {
                        result.append(RomanDigits.valueOf(d)).append(RomanDigits.valueOf(p));
                    } else {
                        if (p != f) {
                            result.append(RomanDigits.valueOf(f));
                        }
                        for (int j=0; j<n; j++) {
                            result.append(RomanDigits.valueOf(d));
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}
