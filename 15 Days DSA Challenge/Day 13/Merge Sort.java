public class Main {
     public static void main(String[] args) {
         int[] arr = {3, 4, 1, 6, 2, 5, 7};
         int n = arr.length;
 
         mergeSort(arr, n);
 
         for (int num : arr) {
             System.out.print(num + " ");
         }
     }
 
     public static void mergeSort(int[] arr, int n) {
         if (n < 2) {
             return;
         }
 
         int mid = n / 2;
         int[] leftArr = new int[mid];
         int[] rightArr = new int[n - mid];
 
         for (int i = 0; i < mid; i++) {
             leftArr[i] = arr[i];
         }
         for (int i = mid; i < n; i++) {
             rightArr[i - mid] = arr[i];
         }
 
         mergeSort(leftArr, mid);
         mergeSort(rightArr, n - mid);
 
         merge(arr, leftArr, rightArr, mid, n - mid);
     }
 
     public static void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
         int i = 0, j = 0, k = 0;
 
         while (i < left && j < right) {
             if (leftArr[i] <= rightArr[j]) {
                 arr[k++] = leftArr[i++];
             } else {
                 arr[k++] = rightArr[j++];
             }
         }
 
         while (i < left) {
             arr[k++] = leftArr[i++];
         }
 
         while (j < right) {
             arr[k++] = rightArr[j++];
         }
     }
 }
 