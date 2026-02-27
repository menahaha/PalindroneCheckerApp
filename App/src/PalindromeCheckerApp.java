import java.util.Scanner;
import java.util.Stack;

/**
 * UC5: Stack-Based Palindrome Checker
 * Goal: Use stack to reverse characters and validate palindrome
 */
public class PalindromeCheckerApp {

    /**
     * Method to check whether a string is palindrome using Stack
     * @param input user entered string
     * @return result message
     */
    public static String checkPalindrome(String input) {

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Convert string to lowercase (optional for case-insensitive check)
        String original = input.toLowerCase();

        // PUSH: insert characters into stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        // POP and compare
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Validate palindrome
        if (original.equals(reversed)) {
            return "Result: The given string is a PALINDROME.";
        } else {
            return "Result: The given string is NOT a palindrome.";
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC5: Stack-Based Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        // Call palindrome checker
        String result = checkPalindrome(input);

        // Print result
        System.out.println(result);

        sc.close();
    }
}