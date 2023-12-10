public class Main {

     class Node {
         public int data;
         public Node next;
 
         Node()
         {
             this.data = 0;
             this.next = null;
         }
         Node(int data)
         {
             this.data = data;
             this.next = null;
         }
         Node(int data, Node next)
         {
             this.data = data;
             this.next = next;
         }
     }
 
     public static void main(String[] args) {
 
     }
 
     public static int findIntersection(Node firstHead, Node secondHead) {
 
         int length1 = getLength(firstHead);
         int length2 = getLength(secondHead);
 
         int lengthDiff = Math.abs(length1 - length2);
 
         if (length1 > length2) {
             while (lengthDiff > 0) {
                 firstHead = firstHead.next;
                 lengthDiff--;
             }
         } else {
             while (lengthDiff > 0) {
                 secondHead = secondHead.next;
                 lengthDiff--;
             }
         }
 
         while (firstHead != null && secondHead != null) {
             if (firstHead == secondHead) {
                 return firstHead.data;
             }
             firstHead = firstHead.next;
             secondHead = secondHead.next;
         }
 
         return -1;
     }
 
     private static int getLength(Node head) {
         int length = 0;
         while (head != null) {
             length++;
             head = head.next;
         }
         return length;
     }
 }
 