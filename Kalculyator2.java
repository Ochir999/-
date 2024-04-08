import java.util.Scanner;

public class Kalculyator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("выберите пункт");
            System.out.println("1.сложение");
            System.out.println("2.вычитание");
            System.out.println("3.умножение");
            System.out.println("1.деление");
            int person = scanner.nextInt();
            int result;
            if (person == 4) {
                break;
            } else if (person == 1) {
                System.out.println("Введите первое число");
                int a = scanner.nextInt();
                System.out.println("Введите второе число");
                int b = scanner.nextInt();
                System.out.println("a " + a);
                System.out.println("b " + b);
                result = a + b;
                System.out.println("Ответ " + result);
            } else if (person == 2) {
                System.out.println("Введите первое число");
                int a = scanner.nextInt();
                System.out.println("Введите второе число");
                int b = scanner.nextInt();
                System.out.println("a " + a);
                System.out.println("b " + b);
                result = a - b;
                System.out.println("Ответ " + result);
            } else if (person == 3) {
                System.out.println("Введите первое число");
                int a = scanner.nextInt();
                System.out.println("Введите второе число");
                int b = scanner.nextInt();
                System.out.println("a " + a);
                System.out.println("b " + b);
                result = a * b;
                System.out.println("Ответ " + result);
            } else if (person == 4) {
                System.out.println("Введите первое число");
                int a = scanner.nextInt();
                System.out.println("Введите второе число");
                int b = scanner.nextInt();
                System.out.println("a " + a);
                System.out.println("b " + b);
                result = a / b;
                System.out.println("Ответ " + result);
            }
        }


    }
}