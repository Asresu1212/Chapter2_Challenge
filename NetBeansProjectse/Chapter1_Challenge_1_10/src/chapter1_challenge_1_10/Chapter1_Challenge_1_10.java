package chapter1_challenge_1_10;

import java.util.Scanner;

public class Chapter1_Challenge_1_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        String input = scanner.nextLine();

        // Try to parse the input to an integer
        try {
            int inputNumber = Integer.parseInt(input);
            
            // Check if the input number is positive
            if (inputNumber <= 0) {
                System.out.println("Please enter a positive integer.");
            } else {
                System.out.println(decryptCode(inputNumber));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid positive integer.");
        } finally {
            scanner.close();
        }
    }

    public static String decryptCode(int n) {
        // Determine the number of digits
        int numDigits = (int) Math.log10(n) + 1;

        // Extract the first digit
        int firstDigit = n / (int) Math.pow(10, numDigits - 1);
        
        // Extract the last digit
        int lastDigit = n % 10;

        // Extract the second digit and second-last digit
        int secondDigit = (n / (int) Math.pow(10, numDigits - 2)) % 10;
        int secondLastDigit = (n / 10) % 10;

        // Calculate the product and the sum
        int product = firstDigit * lastDigit;
        int summation = secondDigit + secondLastDigit;

        // Create the final code
        String finalCode = Integer.toString(product) + Integer.toString(summation);
        
        return "The decrypted code is: " + finalCode;
    }
}