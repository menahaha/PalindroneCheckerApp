/**
 * UC4: Character Array Based Palindrome Check
 * Palindrome Checker App
 * Converts string into char[] and checks palindrome
 * using two-pointer technique.
 */

public class PalindromeCheckerApp {

    /**
     * Main Method – Entry point of application
     */
    public static void main(String[] args) {

        // Original String
        String text = "radar";

        // Convert String to Character Array
        char[] characters = text.toCharArray();

        // Two-pointer variables
        int start = 0;
        int end = characters.length - 1;

        // Flag to track palindrome condition
        boolean isPalindrome = true;

        // Two-pointer comparison
        while (start < end) {

            // Compare start and end characters
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            // Move pointers
            start++;
            end--;
        }

        // Display Result
        if (isPalindrome) {
            System.out.println("The string \"" + text + "\" is a PALINDROME.");
        } else {
            System.out.println("The string \"" + text + "\" is NOT a PALINDROME.");
        }
    }
}