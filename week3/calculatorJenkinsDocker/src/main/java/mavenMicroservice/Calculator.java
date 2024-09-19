package mavenMicroservice;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        while (true) {
            System.out.println("Enter an operation (+, -, *, /) or 'q' to quit:");
            operator = scanner.next().charAt(0);

            if (operator == 'q') {
                System.out.println("Calculator shutting down. Goodbye!");
                break;
            }

            System.out.println("Enter first number:");
            num1 = scanner.nextDouble();

            System.out.println("Enter second number:");
            num2 = scanner.nextDouble();

            try {
                result = calculate(num1, num2, operator);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}