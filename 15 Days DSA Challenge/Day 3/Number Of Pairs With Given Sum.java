import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 2, 5, 4, 3, 2, 4};
        int sum1 = 12;
        System.out.println(pairsWithGivenSum(arr1, sum1)); // Output: 0

        int[] arr2 = {2, 8, 10, 5, -2, 5};
        int sum2 = 10;
        System.out.println(pairsWithGivenSum(arr2, sum2)); // Output: 2
    }

    public static long pairsWithGivenSum(int arr[], int sum) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();
        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            int complement = sum - arr[i];

            if (freqMap.containsKey(complement))
                count += freqMap.get(complement);

            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
