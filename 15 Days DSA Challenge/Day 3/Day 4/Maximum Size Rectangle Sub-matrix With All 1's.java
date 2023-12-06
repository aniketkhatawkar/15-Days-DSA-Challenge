public class Main {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1},
                {1, 1}
        };
        int n1 = 2;
        int m1 = 2;

        int result1 = maximalAreaOfSubMatrixOfAll1(matrix1, n1, m1);
        System.out.println("Maximum area for matrix 1: " + result1);

        int[][] matrix2 = {
                {1, 0, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 1}
        };
        int n2 = 5;
        int m2 = 4;

        int result2 = maximalAreaOfSubMatrixOfAll1(matrix2, n2, m2);
        System.out.println("Maximum area for matrix 2: " + result2);
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, maxAreaHist(dp[i], m));
        }

        return maxArea;
    }

    private static int maxAreaHist(int[] row, int m) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < m) {
            if (stack.isEmpty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int area = row[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = row[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
