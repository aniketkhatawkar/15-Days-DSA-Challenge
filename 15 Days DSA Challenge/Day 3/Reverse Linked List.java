import java.util.Scanner;

public class Main {

    class LinkedListNode<T>
    {
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data)
        {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Main mainObject = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < n; i++) {
            LinkedListNode<Integer> head = null;
            LinkedListNode<Integer> tail = null;

            while (true) {
                int data = scanner.nextInt();
                if (data == -1) {
                    break;
                }

                LinkedListNode<Integer> newNode = mainObject.new LinkedListNode<>(data);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            head = reverseLinkedList(head);

            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println("-1");
        }
        scanner.close();
    }

    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head)
    {
        // Write your code here!
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
