import java.util.Scanner;
public class RentalCarCalulator {

public static void main(String[] args) {
// --- Define Constants ---
    double DAILY_RENTAL_RATE = 29.99;
    double TOLL_TAG_RATE_PER_DAY = 3.95;
    double GPS_RATE_PER_DAY = 2.95;
    double ROADSIDE_RATE_PER_DAY = 3.95;
    int UNDERAGE_LIMIT = 25;
    double SURCHARGE_RATE = 0.30; // 30%// }
    // --- Create Scanner object ---
    Scanner scanner = new Scanner(System.in);
    // --- Declare variables to store user input ---
    String pickupDate;
    int rentalDays;
    String addTollTagChoice;
    String addGpsChoice;
    String addRoadsideChoice;
    int driverAge;
    // --- Declare variables for calculations (initialize to 0) ---
    double basicRentalCost = 0.0;
    double optionsCost = 0.0;
    double underageSurcharge = 0.0;
    double totalCost = 0.0;
    System.out.println("--- Rental Car Calculator ---");
    System.out.print("Enter pickup date (e.g., MM/DD/YYYY): ");
    pickupDate = scanner.nextLine(); // Read the whole line for the date
    System.out.print("Enter number of rental days: ");
    rentalDays = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Add toll tag? (y/n): ");
    addTollTagChoice = scanner.nextLine();
    System.out.print("Add GPS? (y/n): ");
    addGpsChoice = scanner.nextLine();
    System.out.print("Add roadside assistance? (y/n): ");
    addRoadsideChoice = scanner.nextLine();
    System.out.print("Enter driver age: ");
    driverAge = scanner.nextInt();
    // 1. Calculate Basic Rental Cost
    basicRentalCost = rentalDays * DAILY_RENTAL_RATE;

    // 2. Calculate Options Cost
    // Start at zero and add costs if user chose "yes"
    if (addTollTagChoice.equalsIgnoreCase("yes")) {
        optionsCost += rentalDays * TOLL_TAG_RATE_PER_DAY; // Add toll tag cost
    }
    if (addGpsChoice.equalsIgnoreCase("yes")) {
        optionsCost += rentalDays * GPS_RATE_PER_DAY;     // Add GPS cost
    }
    if (addRoadsideChoice.equalsIgnoreCase("yes")) {
        optionsCost += rentalDays * ROADSIDE_RATE_PER_DAY; // Add roadside assistance cost
    }

    // 3. Calculate Underage Driver Surcharge
    // Check if driver age is less than the limit
    if (driverAge < UNDERAGE_LIMIT) {
        // Calculate surcharge ONLY on the basic rental cost
        underageSurcharge = basicRentalCost * SURCHARGE_RATE;
    }
    // If age is 25 or over, underageSurcharge remains 0.0

    // 4. Calculate Total Cost
    totalCost = basicRentalCost + optionsCost + underageSurcharge;
    System.out.println("\n--- Rental Summary ---");
    System.out.println("Pickup Date:          " + pickupDate);
    System.out.println("Rental Days:          " + rentalDays);
    System.out.printf("Basic Car Rental:     $%.2f%n", basicRentalCost);
    System.out.printf("Options Cost:         $%.2f%n", optionsCost);
    // Only display surcharge if it applies
    if (underageSurcharge > 0) {
        System.out.printf("Underage Surcharge:   $%.2f%n", underageSurcharge);
    }
    System.out.println("------------------------------");
    System.out.printf("Total Cost:           $%.2f%n", totalCost);
    System.out.println("------------------------------");

    // --- Close Scanner ---
    scanner.close(); // Good practice to release resources

}
}

