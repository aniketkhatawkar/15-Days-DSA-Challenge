class Node {
     public int data;
     public Node next;
     public Node prev;
 
     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }
 
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }
 
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };
 public class Main {
     public static void main(String[] args) {
 
     }
 
     public static Node removeKthNode(Node head, int K)
     {
         // Write your code here.
         if (head == null || K <= 0)
             return head;
 
         Node firstPointer = head;
         Node secondPointer = head;
         Node prev = null;
 
         for (int i = 0; i < K; i++) {
             if (firstPointer == null)
                 return head;
 
             firstPointer = firstPointer.next;
         }
 
         if (firstPointer == null)
             return head.next;
 
         while (firstPointer != null) {
             firstPointer = firstPointer.next;
             prev = secondPointer;
             secondPointer = secondPointer.next;
         }
 
         if (prev != null)
             prev.next = secondPointer.next;
 
         return head;
     }
 }
 