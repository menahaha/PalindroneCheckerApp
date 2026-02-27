import java.util.Scanner;

/**
 * UC9: Recursive Palindrome Checker
 * Goal: Check palindrome using recursion
 */
public class UseCase9PalindromeCheckerApp {

    /**
     * Recursive method to check palindrome
     * @param text input string
     * @param start starting index
     * @param end ending index
     * @return true if palindrome
     */
    public static boolean isPalindrome(String text, int start, int end) {

        // Base Condition:
        // If pointers cross or become equal → palindrome
        if (start >= end) {
            return true;
        }

        // If mismatch occurs
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursive call (smaller subproblem)
        return isPalindrome(text, start + 1, end - 1);
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC9: Recursive Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine().toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a PALINDROME.");
        } else {
            System.out.println("Result: The given string is NOT a palindrome.");
        }

        sc.close();
    }
}