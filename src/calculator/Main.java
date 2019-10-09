package calculator;

import calculator.arifmetical.Arithmetic;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
	    System.out.println("Please enter expression: (Examples: \"1+2\", \"VI/III\")");

        Arithmetic calc = new Arithmetic();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String result = calc.Calculate(br.readLine());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}