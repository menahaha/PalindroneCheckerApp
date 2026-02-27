import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * UC7: Deque-Based Optimized Palindrome Checker
 * Goal: Compare front and rear elements using Deque
 */
public class PalindromeCheckerApp {

    /**
     * Method to check palindrome using Deque
     * @param input user entered string
     * @return result message
     */
    public static String checkPalindrome(String input) {

        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Convert to lowercase for case-insensitive checking
        String text = input.toLowerCase();

        // Insert characters into deque
        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        // Compare front and rear elements
        while (deque.size() > 1) {

            char front = deque.removeFirst(); // remove from front
            char rear  = deque.removeLast();  // remove from rear

            // If mismatch → not palindrome
            if (front != rear) {
                return "Result: The given string is NOT a palindrome.";
            }
        }

        // All matched
        return "Result: The given string is a PALINDROME.";
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC7: Deque-Based Optimized Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        // Call checker
        String result = checkPalindrome(input);

        // Display result
        System.out.println(result);

        sc.close();
    }
}