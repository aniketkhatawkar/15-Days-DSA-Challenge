import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 4, 3}
        };

        for (int[] testCase : testCases) {
            int[] result = nextGreater(testCase, testCase.length);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static int[] nextGreater(int[] arr, int n) {
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }
}