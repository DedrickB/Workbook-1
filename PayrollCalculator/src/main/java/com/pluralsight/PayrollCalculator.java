package com.pluralsight;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
public class PayrollCalculator {
    public static void main(String[] args) {

        // Declare variables to store user input and the result
        String employeeName = "";
        double hoursWorked = 0.0;
        double payRate = 0.0;
        double grossPay;

        // Use try-with-resources to ensure the Scanner is closed automatically
        // Use Locale.US to ensure '.' is used as the decimal separator regardless of system locale
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {

            // --- Get Employee Name ---
            System.out.print("Enter employee's name: ");
            employeeName = scanner.nextLine(); // Read the whole line for the name

            // --- Get Hours Worked ---
            boolean validInput = false; // Flag for input validation loop
            while (!validInput) {
                System.out.print("Enter hours worked this week: ");
                try {
                    hoursWorked = scanner.nextDouble();
                    // Basic validation: Hours cannot be negative
                    if (hoursWorked >= 0) {
                        validInput = true; // Input is a valid non-negative number
                    } else {
                        System.out.println("Hours worked cannot be negative. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (e.g., 40 or 37.5).");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                }
            }

            // --- Get Pay Rate ---
            validInput = false; // Reset flag for the next input
            while (!validInput) {
                System.out.print("Enter employee's pay rate per hour: ");
                try {
                    payRate = scanner.nextDouble();
                    // Basic validation: Pay rate cannot be negative
                    if (payRate >= 0) {
                        validInput = true; // Input is a valid non-negative number
                    } else {
                        System.out.println("Pay rate cannot be negative. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (e.g., 15.50 or 20).");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Consume the leftover newline character from the last nextDouble()
            // Although not strictly necessary here as we are done reading,
            // it's good practice if more input were to follow.
            scanner.nextLine();

            // --- Calculate Gross Pay ---
            grossPay = hoursWorked * payRate;

            // --- Display the Results ---
            System.out.println("\n--- Employee Payroll Summary ---");
            System.out.println("Employee Name: " + employeeName);
            // Use printf for formatted output of the currency value (2 decimal places)
            System.out.printf("Gross Pay: $%.2f%n", grossPay);

        } // Scanner is automatically closed here

        System.out.println("\nPayroll calculation complete.");
    }
}

