import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node createLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // Function to remove loop from a linked list
    public static Node removeLoop(Node head) {
        Node slow = head, fast = head;
        boolean loopExists = false;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (loopExists) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            while (fast.next != slow) {
                fast = fast.next;
            }

            fast.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input values
        int n = scanner.nextInt(); // Number of elements in the linked list
        int k = scanner.nextInt(); // Index where the loop starts

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Creating the linked list
        Node head = createLinkedList(arr);

        // Creating the loop at index 'k' (if k is valid)
        if (k >= 0 && k < n) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node loopStart = head;
            for (int i = 0; i < k; i++) {
                loopStart = loopStart.next;
            }
            temp.next = loopStart;
        }

        // Removing the loop from the linked list
        head = removeLoop(head);

        // Printing the linked list
        printList(head);

        scanner.close();
    }
}
