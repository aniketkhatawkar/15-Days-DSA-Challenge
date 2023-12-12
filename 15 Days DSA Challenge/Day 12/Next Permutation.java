import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);

        ArrayList<Integer> result = nextPermutation(input);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        // Write your code here.
        int i = permutation.size() - 2;

        while (i >= 0 && permutation.get(i) >= permutation.get(i + 1)) {
            i--;
        }

        if (i >= 0) {
            int j = permutation.size() - 1;

            while (permutation.get(j) <= permutation.get(i)) {
                j--;
            }

            Collections.swap(permutation, i, j);
        }

        reverse(permutation, i + 1, permutation.size() - 1);

        return permutation;
    }

    private static void reverse(ArrayList<Integer> list, int start, int end) {
        while (start < end) {
            Collections.swap(list, start, end);
            start++;
            end--;
        }
    }
}