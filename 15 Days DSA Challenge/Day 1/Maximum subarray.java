import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] testCases = {
                {6, 1, 2, 5, -7, 2, 3},
                {4, -2, -3, -4, 1}
        };

        for (int[] testCase : testCases) {
            ArrayList<Integer> result = maximumsumSubarray(testCase.length - 1, testCase);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<Integer> maximumsumSubarray(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}