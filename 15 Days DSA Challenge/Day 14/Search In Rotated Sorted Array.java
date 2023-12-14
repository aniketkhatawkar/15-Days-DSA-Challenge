public class Main {
     public static void main(String[] args) {
         int[] arr1 = {1,2,3,7,8,9};
         System.out.println(search(arr1, 1));
 
         int[] arr2 = {1, 2, 2};
         System.out.println(search(arr2,3));
 
     }
 
     public static int search(int arr[], int key) {
         // Write your code here.
         int left = 0;
         int right = arr.length - 1;
 
         while (left <= right) {
             int mid = left + (right - left) / 2;
 
             if (arr[mid] == key) {
                 return mid;
             }
 
             if (arr[left] <= arr[mid]) {
                 if (arr[left] <= key && key < arr[mid]) {
                     right = mid - 1;
                 } else {
                     left = mid + 1;
                 }
             } else {
                 if (arr[mid] < key && key <= arr[right]) {
                     left = mid + 1;
                 } else {
                     right = mid - 1;
                 }
             }
         }
 
         return -1;
     }
 }
 