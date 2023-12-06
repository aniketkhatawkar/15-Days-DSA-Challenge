import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        long result = maxSubarraySum(array, size);
        System.out.println(result);
    }

    public static long maxSubarraySum(int[] arr, int n) {
        long maxSum = arr[0];
        long currentSum = arr[0];

        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return Math.max(maxSum, 0); // Return 0 if all elements are negative
    }
}
