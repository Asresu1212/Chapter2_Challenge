       
package lotterynumberanalyzer;

public class LotteryNumberAnalyzer {
    public static void main(String[] args) {
        // Initialize the array of winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        String winningNumber = "";
        double highestAverage = 0.0;

        // Analyze each winning number
        for (String number : winningNumbers) {
            // Remove dashes to create a continuous string
            String continuousString = number.replace("-", "");

            // Check for empty string after removing dashes
            if (continuousString.isEmpty()) {
                System.out.println("Error: Empty winning number.");
                continue;
            }

            // Create an array of integers from the continuous string
            int[] digits = new int[continuousString.length()];
            for (int i = 0; i < continuousString.length(); i++) {
                digits[i] = Character.getNumericValue(continuousString.charAt(i));
                
                // Check for invalid characters
                if (digits[i] < 0) {
                    System.out.println("Error: Invalid character in number: " + number);
                }
            }

            // Calculate the sum of the digits
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }

            // Calculate the average of the digits
            double average = (double) sum / digits.length;

            // Print analysis for the current ticket
            System.out.printf("Analyzing: %s%n", number);
            System.out.printf("Digit Sum: %d, Digit Average: %.1f%n", sum, average);

            // Determine the winning number with the highest average
            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        // Announce the winning number
        if (!winningNumber.isEmpty()) {
            System.out.printf("The winning number with the highest average is: %s with an average of %.1f%n", winningNumber, highestAverage);
        } else {
            System.out.println("No valid winning numbers were found.");
        }
    }
}