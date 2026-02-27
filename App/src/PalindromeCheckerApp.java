import java.util.*;

/**
 * UC13: Performance Comparison
 * Goal: Compare execution time of different palindrome algorithms
 */
public class PalindromeCheckerApp {

    /* ================= METHOD 1 : TWO POINTER ================= */
    public static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    /* ================= METHOD 2 : STACK ================= */
    public static boolean stackCheck(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    /* ================= METHOD 3 : DEQUE ================= */
    public static boolean dequeCheck(String input) {

        Deque<Character> deque = new LinkedList<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast())
                return false;
        }
        return true;
    }

    /* ================= MAIN METHOD ================= */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13: Palindrome Algorithm Performance Comparison ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine().toLowerCase();

        long startTime, endTime;

        /* -------- Two Pointer -------- */
        startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        endTime = System.nanoTime();
        long time1 = endTime - startTime;

        /* -------- Stack -------- */
        startTime = System.nanoTime();
        boolean result2 = stackCheck(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        /* -------- Deque -------- */
        startTime = System.nanoTime();
        boolean result3 = dequeCheck(input);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        /* -------- Display Results -------- */
        System.out.println("\nRESULT:");
        System.out.println("Palindrome Status: " +
                (result1 ? "PALINDROME" : "NOT PALINDROME"));

        System.out.println("\nExecution Time Comparison (nanoseconds)");
        System.out.println("----------------------------------------");
        System.out.println("Two Pointer Method : " + time1);
        System.out.println("Stack Method       : " + time2);
        System.out.println("Deque Method       : " + time3);

        sc.close();
    }
}