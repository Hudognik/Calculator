package calculator.arifmetical;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class NumberConverter {
    int RomanToArabic(String number) {
        int result = 0;
        int prev = 0;
        for (int i=number.length()-1; i>=0; i--) {
            int value = RomanDigits.indexOf(number.charAt(i));
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

        List<RomanDigits> digits = Arrays.asList(RomanDigits.values());
        Collections.sort(digits);
        Collections.reverse(digits);
        for (int i=0; i<number.length(); i++) {
            if (Integer.parseInt(number.substring(i)) == 0) break;

            int depth = (int) Math.pow(10, number.length()-(i+1));
            int currentNumber = Character.getNumericValue(number.charAt(i))*depth;
            if (currentNumber == 0) continue;

            RomanDigits digit = RomanDigits.valueOf(currentNumber+depth);
            if (digit == null) {
                for (RomanDigits d : digits) {
                    int digitValue = d.index();
                    if (currentNumber >= digitValue) {
                        int count = currentNumber / digitValue;
                        for (int j=0; j<count; j++) {
                            currentNumber -= digitValue;
                            result.append(d.toString());
                        }
                    }
                    if (currentNumber == 0) break;
                }
            } else {
                result.append(RomanDigits.valueOf(depth)).append(digit.toString());
            }
        }
        return result.toString();
    }
}
