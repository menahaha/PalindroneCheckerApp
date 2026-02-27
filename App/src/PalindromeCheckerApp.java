import java.util.Scanner;

/**
 * UC10: Case-Insensitive & Space-Ignored Palindrome Checker
 * Goal: Ignore spaces and case while checking palindrome
 */
public class PalindromeCheckerApp {

    /**
     * Method to normalize string and check palindrome
     * @param input user entered string
     * @return result message
     */
    public static String checkPalindrome(String input) {

        // Step 1: Normalize string
        // remove spaces & special characters, convert to lowercase
        String normalized = input
                .replaceAll("[^a-zA-Z0-9]", "") // remove spaces & symbols
                .toLowerCase();

        // Step 2: Palindrome check using two-pointer technique
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {
                return "Result: The given string is NOT a palindrome.";
            }

            start++;
            end--;
        }

        return "Result: The given string is a PALINDROME.";
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        String result = checkPalindrome(input);

        System.out.println(result);

        sc.close();
    }
}