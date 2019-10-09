package calculator.arifmetical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arithmetic {
    private NumberConverter converter;
    private Pattern ArabicExpressionPattern, RomanExpressionPattern;
    private NumberSystem system;
    private String operandA,operandB,operation;

    public Arithmetic() {
        String arabicNumberPattern = "([1-9]|10)";
        String romanNumberPattern = "(V?[I]{1,3}|I?[VX])";
        String calcOperatorPattern = "([+-/*])";
        ArabicExpressionPattern = Pattern.compile("^" + arabicNumberPattern + calcOperatorPattern + arabicNumberPattern + "$");
        RomanExpressionPattern = Pattern.compile("^" + romanNumberPattern + calcOperatorPattern + romanNumberPattern + "$");
        converter = new NumberConverter();
    }

    public String Calculate(String expression) throws CalculationException {
        expression = expression.toUpperCase().trim(); // JUST FOR TESTS!
        Parse(expression);

        int a,b,c = 0;

        if (system == NumberSystem.ROMAN) {
            a = converter.RomanToArabic(operandA);
            b = converter.RomanToArabic(operandB);
        } else {
            a = Integer.parseInt(operandA);
            b = Integer.parseInt(operandB);
        }

        switch (this.operation) {
            case "+":
                c = a+b;
                break;
            case "-":
                c = a-b;
                if (c <= 0) {
                    throw new CalculationException("Result can't be zero or less!");
                }
                break;
            case "*":
                c = a*b;
                break;
            case "/":
                c = a/b;
                break;
        }

        String result = String.valueOf(c);
        if (this.system == NumberSystem.ARABIC) {
            return result;
        } else {
            return converter.ArabicToRoman(result);
        }
    }

    private void Parse(String expression) throws CalculationException {
        if (Match(ArabicExpressionPattern, expression)) {
            system = NumberSystem.ARABIC;
        } else {
            if (Match(RomanExpressionPattern, expression)) {
                system = NumberSystem.ROMAN;
            } else {
                throw new CalculationException("Wrong input format!");
            }
        }
    }

    private boolean Match(Pattern pattern, String expression)  {
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            operandA = matcher.group(1);
            operandB = matcher.group(3);
            operation = matcher.group(2);

            return true;
        }
        return false;
    }
}
