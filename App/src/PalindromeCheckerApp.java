import java.util.*;

/**
 * UC12: Strategy Pattern for Palindrome Algorithms
 * Goal: Choose palindrome algorithm dynamically
 */
public class UseCase12PalindromeCheckerApp {

    /* ================= STRATEGY INTERFACE ================= */
    interface PalindromeStrategy {
        boolean check(String input);
    }

    /* ================= STACK STRATEGY ================= */
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            String reversed = "";
            while (!stack.isEmpty()) {
                reversed += stack.pop();
            }

            return input.equals(reversed);
        }
    }

    /* ================= DEQUE STRATEGY ================= */
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Deque<Character> deque = new LinkedList<>();

            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }

    /* ================= CONTEXT CLASS ================= */
    static class PalindromeChecker {

        private PalindromeStrategy strategy;

        // Inject strategy at runtime
        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.check(input);
        }
    }

    /* ================= MAIN METHOD ================= */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine().toLowerCase();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        PalindromeChecker checker = new PalindromeChecker();

        // Runtime strategy selection (Polymorphism)
        switch (choice) {
            case 1:
                checker.setStrategy(new StackStrategy());
                break;
            case 2:
                checker.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        boolean result = checker.execute(input);

        if (result)
            System.out.println("Result: The given string is a PALINDROME.");
        else
            System.out.println("Result: The given string is NOT a palindrome.");

        sc.close();
    }
}