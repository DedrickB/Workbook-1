package com.pluralsight;
import java.util.Scanner;
public class SandwichShopLoaded {
    public static void main(String[] args) {

        // --- Define Prices, Costs, and Discounts ---
        double regularPrice = 5.45;
        double largePrice = 8.95;
        double loadedRegularCost = 1.00; // Extra cost for loaded regular
        double loadedLargeCost = 1.75;   // Extra cost for loaded large

        double studentDiscountRate = 0.10; // 10%
        double seniorDiscountRate = 0.20;  // 20%
        int studentAgeLimit = 17;
        int seniorAgeStart = 65;

        Scanner scanner = new Scanner(System.in); // Tool to get user input

        double basePrice = 0.0;
        String sizeName = ""; // To store the name of the size
        double loadedAddOn = 0.0; // To store the extra cost for loaded
        double priceBeforeDiscount = 0.0; // Price including loaded option
        double discountRate = 0.0; // Assume no discount initially
        String discountType = "None"; // Description of discount
        double finalCost = 0.0;

        // --- Get Sandwich Size ---
        System.out.println("--- Sandwich Size ---");
        System.out.printf("1: Regular ($%.2f)%n", regularPrice);
        System.out.printf("2: Large ($%.2f)%n", largePrice);
        System.out.print("Enter sandwich size choice (1 or 2): ");


        int sizeChoice = scanner.nextInt();

        // Determine base price based on choice
        if (sizeChoice == 1) {
            basePrice = regularPrice;
            sizeName = "Regular";
        } else if (sizeChoice == 2) {
            basePrice = largePrice;
            sizeName = "Large";
        } else {
            System.out.println("Invalid size choice. Cannot calculate price.");

        }

        // --- Ask about Loaded Option (only if size was valid) ---
        if (basePrice > 0) { // Only proceed if a valid size was chosen
            System.out.print("Would you like the sandwich loaded? (yes/no): ");

            String loadedChoice = scanner.next();

            if (loadedChoice.equalsIgnoreCase("yes")) {
                if (sizeChoice == 1) {
                    loadedAddOn = loadedRegularCost;
                } else { // sizeChoice must be 2 if basePrice > 0
                    loadedAddOn = loadedLargeCost;
                }
                System.out.printf("Adding loaded cost: $%.2f%n", loadedAddOn);
            } else {
                System.out.println("Not adding loaded option.");
            }

            // Calculate price including the loaded option (if any)
            priceBeforeDiscount = basePrice + loadedAddOn;

            // --- Get Customer Age ---
            System.out.print("Enter your age: ");
            // Read the integer age the user types
           
            int age = scanner.nextInt();

            // Determine discount based on age
            if (age <= studentAgeLimit && age > 0) { // Check for positive age too
                discountRate = studentDiscountRate;
                discountType = String.format("Student (%.0f%%)", discountRate * 100);
            } else if (age >= seniorAgeStart) {
                discountRate = seniorDiscountRate;
                discountType = String.format("Senior (%.0f%%)", discountRate * 100);
            } else if (age < 0) {
                System.out.println("Invalid age entered. No discount applied.");
                discountType = "Invalid Age";
            } else {
                discountType = "None"; // No discount applies
            }

            // --- Calculate Final Cost ---
            // Apply discount to the price *after* adding the loaded cost
            double discountAmount = priceBeforeDiscount * discountRate;
            finalCost = priceBeforeDiscount - discountAmount;

            // --- Display Result ---
            System.out.println("\n--- Order Summary ---");
            System.out.printf("Sandwich Size:      %s ($%.2f)%n", sizeName, basePrice);
            if (loadedAddOn > 0) {
                System.out.printf("Loaded Option:      Yes (+$%.2f)%n", loadedAddOn);
                System.out.printf("Price Before Disc:  $%.2f%n", priceBeforeDiscount);
            }
            System.out.printf("Age:                %d%n", age);
            System.out.printf("Discount Applied:   %s%n", discountType);
            if (discountAmount > 0) {
                System.out.printf("Discount Amount:    -$%.2f%n", discountAmount);
            }
            System.out.println("----------------------");
            System.out.printf("Final Cost:         $%.2f%n", finalCost);
            System.out.println("----------------------");

        } // End of processing block (if basePrice > 0)

        scanner.close(); // Good practice to close the scanner when done
    }
}

