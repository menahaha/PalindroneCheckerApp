/**
 * UC3: Palindrome Check Using String Reverse
 * Palindrome Checker App
 * Checks whether a string is a palindrome by reversing it.
 */

public class PalindromeCheckerApp {

    /**
     * Main Method – Entry point of the application
     */
    public static void main(String[] args) {

        // Original String
        String original = "level";

        // Variable to store reversed string
        String reversed = "";

        // Reverse string using for loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i); // String concatenation
        }

        // Compare original and reversed string
        if (original.equals(reversed)) {
            System.out.println("The string \"" + original + "\" is a PALINDROME.");
        } else {
            System.out.println("The string \"" + original + "\" is NOT a PALINDROME.");
        }

        // Display reversed string
        System.out.println("Reversed String : " + reversed);
    }
}