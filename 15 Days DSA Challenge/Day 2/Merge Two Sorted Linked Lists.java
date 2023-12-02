public class Main {
     public class LinkedListNode<T> {
         T data;
         LinkedListNode<T> next;
 
         public LinkedListNode(T data) {
             this.data = data;
         }
     }
 
     public static void main(String[] args) {
         Main mainInstance = new Main();
 
         LinkedListNode<Integer> first = mainInstance.new LinkedListNode<>(1);
         first.next = mainInstance.new LinkedListNode<>(4);
         first.next.next = mainInstance.new LinkedListNode<>(5);
 
         LinkedListNode<Integer> second = mainInstance.new LinkedListNode<>(2);
         second.next = mainInstance.new LinkedListNode<>(3);
         second.next.next = mainInstance.new LinkedListNode<>(5);
 
         LinkedListNode<Integer> result = mainInstance.sortTwoLists(first, second);
 
         // Printing the merged sorted list
         while (result != null) {
             System.out.print(result.data + " ");
             result = result.next;
         }
     }
 
     public LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
         // Write your code here.
         if (first == null) {
             return second;
         }
         if (second == null) {
             return first;
         }
 
         LinkedListNode<Integer> merged = new LinkedListNode<>(0);
         LinkedListNode<Integer> current = merged;
 
         // Merge the lists
         while (first != null && second != null) {
             if (first.data <= second.data) {
                 current.next = first;
                 first = first.next;
             } else {
                 current.next = second;
                 second = second.next;
             }
             current = current.next;
         }
 
         // Add remaining elements of first or second list if any
         if (first != null) {
             current.next = first;
         }
         if (second != null) {
             current.next = second;
         }
 
         return merged.next;
     }
 }
 