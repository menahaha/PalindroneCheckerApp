import java.util.Scanner;

/**
 * UC8: Linked List Based Palindrome Checker
 * Goal: Check palindrome using singly linked list
 */
public class PalindromeCheckerApp {

    /* Node class for Singly Linked List */
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Build linked list from string
     */
    public static Node buildList(String input) {
        Node head = null, tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    /**
     * Reverse a linked list
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    /**
     * Check palindrome using linked list
     */
    public static String checkPalindrome(String input) {

        String text = input.toLowerCase();

        // Step 1: Convert string to linked list
        Node head = buildList(text);

        if (head == null || head.next == null)
            return "Result: The given string is a PALINDROME.";

        // Step 2: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node secondHalf = reverse(slow.next);

        // Step 4: Compare both halves
        Node firstHalf = head;
        Node tempSecond = secondHalf;

        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                return "Result: The given string is NOT a palindrome.";
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        return "Result: The given string is a PALINDROME.";
    }

    /**
     * Main Method
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC8: Linked List Based Palindrome Checker ===");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        String result = checkPalindrome(input);

        System.out.println(result);

        sc.close();
    }
}