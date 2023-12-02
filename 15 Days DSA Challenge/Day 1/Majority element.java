import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 9, 2, 2};
        int n1 = arr1.length;
        int result1 = findMajority(arr1, n1);
        System.out.println(result1); // Expected Output: 2

        int[] arr2 = {8, 5, 1, 9};
        int n2 = arr2.length;
        int result2 = findMajority(arr2, n2);
        System.out.println(result2);
    }
    public static int findMajority(int[] arr, int n) {
        // Write your code here.
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int majorityCount = n / 2;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > majorityCount) {
                return entry.getKey();
            }
        }

        return -1;
    }
}