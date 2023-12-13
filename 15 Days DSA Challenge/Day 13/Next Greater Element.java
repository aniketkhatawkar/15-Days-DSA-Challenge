import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] input1 = {1, 5, 3, 4, 2};
        int[] output1 = nextGreaterElement(input1, input1.length);
        System.out.println(Arrays.toString(output1));

        int[] input2 = {5, 5, 5, 5, 5};
        int[] output2 = nextGreaterElement(input2, input2.length);
        System.out.println(Arrays.toString(output2));
    }

    public static int[] nextGreaterElement(int[] arr, int n) {
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }
}
