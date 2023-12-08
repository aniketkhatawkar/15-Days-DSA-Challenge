import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Example usage:
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2));
        int k = 3;
        ArrayList<Integer> result = getMaximumOfSubarrays(nums, k);
        System.out.println(result); // Output: [1, 2, 2]
    }

    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums.get(deque.peekLast()) < nums.get(i)) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result.add(nums.get(deque.peek()));
            }
        }

        return result;
    }
}
