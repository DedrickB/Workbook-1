package com.pluralsight;
// Defines the package where this class resides.
import java.util.Scanner;
// Imports the Scanner class, which is needed to read input from the user.
import static java.lang.System.out;
// Imports the 'out' object directly from the System class for convenience
/**
 * A basic command-line calculator that performs addition, subtraction,
 * multiplication, or division on two integers provided by the user.
 */
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Enter a number: ");
        int number = scanner.nextInt();
        out.println("Enter an operator (+, -, *, /): ");
        String operator = scanner.next();
        out.println("Enter a second number: ");
        int secondNumber = scanner.nextInt();
        int result = 0;
        switch (operator) {
        case "+":
                result = number + secondNumber;
                break;
            case "-":
                result = number - secondNumber;
                break;
            case "*":
                result = number * secondNumber;
                break;
        case "/":
        result = number / secondNumber;
         break;
        default:
            out.println("Invalid operator");
         break;
        }
     out.println(result);
     scanner.close();
     }
    }