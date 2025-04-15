package com.pluralsight;
import java.util.*;

public class SandwichShop {
    public static void main(String[] args) {
        double regularPrice = 5.45;
        double largePrice = 8.95;
        double studentDiscountRate = 0.10; // 10%
        double seniorDiscountRate = 0.20;  // 20%
        int studentAgeLimit = 17;
        int seniorAgeStart = 65;
        double basePrice = 0.0;
        double discountRate = 0.0; // Assume no discount initially
        double finalCost = 0.0;
        Scanner scanner = new Scanner(System.in);

        // --- Get Sandwich Size ---
        System.out.println("--- Sandwich Size ---");
        // Using printf to format the price nicely to 2 decimal places
        System.out.printf("1: Regular ($%.2f)%n", regularPrice);
        System.out.printf("2: Large ($%.2f)%n", largePrice);
        System.out.print("Enter sandwich size choice (1 or 2): ");

        // Read the integer the user types
        // NOTE: This simple version assumes the user WILL enter a number.
        // A more robust version would use try-catch for non-number input.
        int sizeChoice = scanner.nextInt();

        // Determine base price based on choice
        if (sizeChoice == 1) {
            basePrice = regularPrice;
            System.out.println("Selected: Regular");
        } else if (sizeChoice == 2) {
            basePrice = largePrice;
            System.out.println("Selected: Large");
        } else {
            System.out.println("Invalid size choice. Cannot calculate price.");
            // Exit or handle error - for simplicity, we'll let the price be 0
        }

        // --- Get Customer Age ---
        // Only ask for age if a valid size was selected
        if (basePrice > 0) {
            System.out.print("Enter your age: ");
            // Read the integer age the user types
            // NOTE: Again, assuming the user enters a valid number.
            int age = scanner.nextInt();

            // Determine discount based on age
            if (age <= studentAgeLimit && age > 0) { // Check for positive age too
                discountRate = studentDiscountRate;
                System.out.println("Applying Student Discount (10%).");
            } else if (age >= seniorAgeStart) {
                discountRate = seniorDiscountRate;
                System.out.println("Applying Senior Discount (20%).");
            } else if (age < 0) {
                System.out.println("Invalid age entered. No discount applied.");
            } else {
                System.out.println("No age discount applied.");
            }

            // --- Calculate Final Cost ---
            double discountAmount = basePrice * discountRate;
            finalCost = basePrice - discountAmount;
            // Alternatively: finalCost = basePrice * (1.0 - discountRate);

            // --- Display Result ---
            System.out.println("\n--- Final Cost ---");
            // Use printf again for nice currency formatting
            System.out.printf("The final cost of your sandwich is: $%.2f%n", finalCost);

        } else {
            System.out.println("Skipping cost calculation due to invalid size.");
        }


        scanner.close(); // Good practice to close the scanner when done
    }
}

