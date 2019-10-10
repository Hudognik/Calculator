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

    String ArabicToRoman(String number) {
        StringBuilder result = new StringBuilder();
        int count = number.length();
        for (int i=1; i<=count; i++) {
            int d = (int) Math.pow(10,count-i);
            int n = Character.getNumericValue(number.charAt(i-1));
            if (n > 0) {
                int f = 5*d;
                int p = f;
                if (n == 5) {
                    result.append(RomanDigits.valueOf(f)); // 5
                } else {
                    if (n > 5) {
                        n = n-5;
                        p = d*10;
                    }
                    if (n == 4) {
                        result.append(RomanDigits.valueOf(d)).append(RomanDigits.valueOf(p)); // 4,9
                    } else {
                        if (p != f) {
                            result.append(RomanDigits.valueOf(f)); // 6,7,8
                        }
                        for (int j=0; j<n; j++) {
                            result.append(RomanDigits.valueOf(d)); // 1,2,3
                        }
                    }
                }
            }
        }
        return result.toString();
    }
}