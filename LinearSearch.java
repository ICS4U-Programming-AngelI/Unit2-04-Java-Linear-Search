import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class LinearSearch {

    /**
     * Private constructor to prevent creating objects of this class.
     */
    private LinearSearch() {
        // prevents instantiation of this class.
    }

    /**
     * Generate random array of 10 numbers between 0 and 100.
     *
     * @return an array containing 10 random integers between 0 and 100
     */
    public static int[] generateRandomArray() {
        // Create a random number generator
        Random rand = new Random();

        // Create an empty array of size 10
        int[] array = new int[10];

        // Fill the array with random numbers between 0 and 100
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100); // inclusive 0, exclusive 100
        }

        // Return the completed random array
        return array;
    }

    /**
     * Search for a number in the array using linear search.
     *
     * @param targetNumber the number to find
     * @param array the array to search in
     * @return the index if found, -1 otherwise
     */
    public static int linearSearch(final int targetNumber, final int[] array) {
        // Loop through each number in the array
        for (int index = 0; index < array.length; index++) {

            // If the current element matches the target, return its index
            if (array[index] == targetNumber) {
                return index;
            }
        }

        // If the number is not found, return -1
        return -1;
    }

    /**
     * The entry point of the program.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Generate a random array of numbers
        int[] numbers = generateRandomArray();

        // Sort the array to make it easier to read
        Arrays.sort(numbers);

        // Repeat until the user types 'q'
        while (true) {
            // Print out the list of numbers
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println(); // move to next line

            // Ask the user for a number to search
            System.out.print("Number: ");
            String input = scanner.nextLine(); // read input as a string

            int target;
            try {
                // Try to convert the input into a number
                target = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // If conversion fails,
                // check if user wants to quit
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Thank you for playing!");
                    break; // Exit the loop
                } else {
                    // Invalid input so ask again
                    System.out.println("Invalid input, try again.");
                    continue;
                }
            }

            // Call the linear search function
            int index = linearSearch(target, numbers);

            // Display result to the user
            if (index >= 0) {
                System.out.println(
                    "The number " + target + " is found at index " + index + "."
                );
            } else {
                System.out.println(
                    "The number " + target + " is not found in the list."
                );
            }
        }

        // Close the scanner
        scanner.close();
    }
}
