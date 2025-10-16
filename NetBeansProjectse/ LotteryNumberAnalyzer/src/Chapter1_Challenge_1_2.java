public class Chapter1_Challenge_1_2 {
    public static void main(String[] args) {
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

        String winningNumberWithHighestAverage = "";
        double highestAverage = 0.0;

        for (String number : winningNumbers) {
            try {
                // Remove dashes
                String cleaned = number.replace("-", "");

                // Validate cleaned string
                if (!cleaned.matches("\\d+")) {
                    throw new IllegalArgumentException("Invalid characters found in number: " + number);
                }

                // Convert to char array
                char[] digits = cleaned.toCharArray();

                // Create integer array and calculate sum
                int[] digitValues = new int[digits.length];
                int sum = 0;

                for (int j = 0; j < digits.length; j++) {
                    int digit = Character.getNumericValue(digits[j]);
                    if (digit < 0 || digit > 9) {
                        throw new NumberFormatException("Invalid digit: " + digits[j]);
                    }
                    digitValues[j] = digit;
                    sum += digit;
                }

                double average = (double) sum / digitValues.length;

                // Print analysis
                System.out.println("Analyzing: " + number);
                System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);

                // Track highest average
                if (average > highestAverage) {
                    highestAverage = average;
                    winningNumberWithHighestAverage = number;
                }

            } catch (Exception e) {
                System.out.println("Error analyzing number \"" + number + "\": " + e.getMessage());
            }
        }

        // Final result
        if (!winningNumberWithHighestAverage.isEmpty()) {
            System.out.println("The winning number with the highest average is: " +
                    winningNumberWithHighestAverage + " with an average of " + highestAverage);
        } else {
            System.out.println("No valid winning numbers were analyzed.");
        }
    }
}
