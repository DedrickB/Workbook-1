package com.pluralsight;

public class MathApp {

    public static void main(String[] args) {
        double bobSalary = 55000.50;
        double garySalary = 62000.75;
        double highestSalary;
        highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("Question 1: Highest Salary");
        System.out.println("Bob's salary: $" + bobSalary);
        System.out.println("Gary's salary: $" + garySalary);
        System.out.println("The highest salary is: $" + highestSalary);
        System.out.println();
        // ---------------------------------

        double carPrice = 25999.99;
        double truckPrice = 48500.00;
        double lowestPrice; // Variable to store the result


        lowestPrice = Math.min(carPrice, truckPrice);


        System.out.println("Question 2: Smallest Price");
        System.out.println("Car price: $" + carPrice);
        System.out.println("Truck price: $" + truckPrice);
        System.out.println("The lowest price is: $" + lowestPrice);
        System.out.println();

        // ---------------------------------
        double circleRadius = 7.25;
        double circleArea;


        circleArea = Math.PI * Math.pow(circleRadius, 2);



        System.out.println("Question 3: Area of a Circle");
        System.out.println("The radius of the circle is: " + circleRadius);
        System.out.println("The area of the circle is: " + circleArea);
        System.out.println();

        // ---------------------------------


        double numberForSqrt = 5.0;
        double squareRootResult; // Variable to store the result

        // Calculate the square root using Math.sqrt()
        squareRootResult = Math.sqrt(numberForSqrt);

        // Display the results with context
        System.out.println("Question 4: Square Root");
        System.out.println("The number is: " + numberForSqrt);
        System.out.println("The square root is: " + squareRootResult);
        System.out.println();
// ---------------------------------
        double point1X = 5.0;
        double point1Y = 10.0;
        double point2X = 85.0;
        double point2Y = 50.0;
        double distance; // Variable to store the result

        // Calculate the differences in x and y coordinates
        double deltaX = point2X - point1X;
        double deltaY = point2Y - point1Y;

        // Calculate the distance using the distance formula: sqrt((x2-x1)^2 + (y2-y1)^2)
        // which simplifies to: sqrt(deltaX^2 + deltaY^2)
        distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        // An alternative using Math.hypot which calculates sqrt(x^2 + y^2) directly
        // distance = Math.hypot(deltaX, deltaY);

        // Display the results with context
        System.out.println("Question 5: Distance Between Points");
        System.out.println("Point 1 coordinates: (" + point1X + ", " + point1Y + ")");
        System.out.println("Point 2 coordinates: (" + point2X + ", " + point2Y + ")");
        System.out.println("The distance between the points is: " + distance);
        System.out.println();
// ---------------------------------
        double negativeValue = -3.8;
        double absoluteValueResult; // Variable to store the result

        // Calculate the absolute value using Math.abs()
        absoluteValueResult = Math.abs(negativeValue);

        // Display the results with context
        System.out.println("Question 6: Absolute Value");
        System.out.println("The original value is: " + negativeValue);
        System.out.println("The absolute (positive) value is: " + absoluteValueResult);
        System.out.println();
        // -------------------------
        double randomNumber;

        // Generate a random number between 0.0 (inclusive) and 1.0 (exclusive)
        randomNumber = Math.random();

        // Display the result with context
        System.out.println("Question 7: Random Number");
        System.out.println("A random number between 0.0 and 1.0: " + randomNumber);
        System.out.println();{
        }



    }
    }