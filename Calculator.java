import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private static final Map<String, Integer> ROMAN_NUMERALS = new HashMap<>();

    static {
        ROMAN_NUMERALS.put("I", 1);
        ROMAN_NUMERALS.put("II", 2);
        ROMAN_NUMERALS.put("III", 3);
        ROMAN_NUMERALS.put("IV", 4);
        ROMAN_NUMERALS.put("V", 5);
        ROMAN_NUMERALS.put("VI", 6);
        ROMAN_NUMERALS.put("VII", 7);
        ROMAN_NUMERALS.put("VIII", 8);
        ROMAN_NUMERALS.put("IX", 9);
        ROMAN_NUMERALS.put("X", 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите выражение (например, 'III + IV'): ");
        String input = scanner.nextLine().trim();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Ошибка: неверный формат ввода");
            return;
        }

        String num1Str = parts[0];
        String operator = parts[1];
        String num2Str = parts[2];

        if (!isValidInput(num1Str, num2Str, operator)) {
            System.out.println("Ошибка: неверный формат ввода");
            return;
        }

        int num1 = parseInput(num1Str);
        int num2 = parseInput(num2Str);

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Ошибка: неверный оператор");
                return;
        }

        if (isRomanInput(num1Str, num2Str)) {
            if (result <= 0) {
                System.out.println("Ошибка: результат работы с римскими числами не может быть меньше единицы");
                return;
            }
            String romanResult = toRoman(result);
            System.out.println("Результат: " + romanResult);
        } else {
            System.out.println("Результат: " + result);
        }
    }

    private static boolean isValidInput(String num1Str, String num2Str, String operator) {
        return isValidNumber(num1Str) && isValidNumber(num2Str) && isValidOperator(operator);
    }

    private static boolean isValidNumber(String number) {
        return number.matches("[IVXLCDM]+") || number.matches("\\d+");
    }

    private static boolean isValidOperator(String operator) {
        return operator.matches("[+\\-*/]");
    }

    private static boolean isRomanInput(String num1Str, String num2Str) {
        return num1Str.matches("[IVXLCDM]+") && num2Str.matches("[IVXLCDM]+");
    }

    private static int parseInput(String input) {
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        } else {
            return toArabic(input);
        }
    }

    private static int toArabic(String roman) {
        int result = 0;
        int prevValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i);
            int value = ROMAN_NUMERALS.get(String.valueOf(ch));
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    private static String toRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Результат работы с римскими числами не может быть меньше единицы");
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : ROMAN_NUMERALS.entrySet()) {
            String roman = entry.getKey();
            int value = entry.getValue();
            while (number >= value) {
                result.append(roman);
                number -= value;
            }
        }
        return result.toString();
    }
}