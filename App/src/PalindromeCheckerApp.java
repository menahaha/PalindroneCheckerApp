/**
 * UC1: Application Entry & Welcome Message
 * Palindrome Checker App
 * Displays application details at startup.
 */

/**
 * UC2: Print a Hardcoded Palindrome Result
 * Palindrome Checker App
 * Checks whether a hardcoded string is a palindrome.
 */

public class PalindromeCheckerApp {

    /**
     * Main Method – Entry point of the application
     */
    public static void main(String[] args) {

        // Hardcoded String (String Literal)
        String word = "madam";

        // Variable to store reversed string
        String reversed = "";

        // Reverse the string using loop
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Conditional Statement (if-else)
        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a PALINDROME.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a PALINDROME.");
        }

        // Program Exit Message
        System.out.println("Program executed successfully.");
    }
}