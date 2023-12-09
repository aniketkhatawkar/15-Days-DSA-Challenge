import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }

    public static int longestIncreasingPath(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        if (mat == null || n == 0 || m == 0) {
            return 0;
        }

        int[][] memo = new int[n][m];
        int maxPath = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int path = dfs(mat, i, j, memo, n, m);
                maxPath = Math.max(maxPath, path);
            }
        }

        return maxPath;
    }

    private static int dfs(ArrayList<ArrayList<Integer>> mat, int i, int j, int[][] memo, int n, int m) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxPath = 1;

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < n && y >= 0 && y < m && mat.get(x).get(y) > mat.get(i).get(j)) {
                int path = 1 + dfs(mat, x, y, memo, n, m);
                maxPath = Math.max(maxPath, path);
            }
        }

        memo[i][j] = maxPath;
        return maxPath;
    }
}
