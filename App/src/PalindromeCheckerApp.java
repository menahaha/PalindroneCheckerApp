import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 * UC6: Queue + Stack Based Palindrome Checker
 * Goal: Demonstrate FIFO vs LIFO using Queue and Stack
 */
public class PalindromeCheckerApp {

    /**
     * Method to check palindrome using Queue and Stack
     * @param input user entered string
     * @return result message
     */
    public static String checkPalindrome(String input) {

        // Create Queue (FIFO) and Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Convert to lowercase for case-insensitive comparison
        String text = input.toLowerCase();

        // Enqueue and Push characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            queue.add(ch);   // ENQUEUE (FIFO)
            stack.push(ch);  // PUSH (LIFO)
        }

        // Compare dequeue vs pop
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove(); // DEQUEUE
            char fromStack = stack.pop();    // POP

            // If mismatch → not palindrome
            if (fromQueue != fromStack) {
                return "Result: The given string is NOT a palindrome.";
            }
        }

        // All characters matched
        return "Result: The given string is a PALINDROME.";
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC6: Queue + Stack Based Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        // Call checker
        String result = checkPalindrome(input);

        // Display result
        System.out.println(result);

        sc.close();
    }
}