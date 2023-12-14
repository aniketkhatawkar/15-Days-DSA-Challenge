public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 4, 11, 1, 16, 8};
        System.out.println(fun(arr1));

        int[] arr2 = {1, 2, 2};
        System.out.println(fun(arr2));
        
    }

    public static int fun(int arr[]) {
        //Your code goes here
        int n = arr.length;
        int[] piles = new int[n];
        int len = 0;

        for (int num : arr) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (piles[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            piles[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len;
    }
}
