import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 0, 1}
        };
        int x1 = 3;
        int y1 = 3;

        int result1 = minCostToDestination(matrix1, x1, y1);
        System.out.println("Sample Output 1: " + result1);

        int[][] matrix2 = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        int x2 = 3;
        int y2 = 4;

        int result2 = minCostToDestination(matrix2, x2, y2);
        System.out.println("Sample Output 2: " + result2);
    }

    static class Cell {
        int row;
        int col;
        int cost;

        Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public static int minCostToDestination(int[][] matrix, int x, int y) {
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Cell> queue = new LinkedList<>();

        if (matrix[0][0] == 0 || matrix[x][y] == 0) {
            return -1;
        }

        queue.offer(new Cell(0, 0, 0));

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int currentRow = current.row;
            int currentCol = current.col;
            int currentCost = current.cost;

            if (currentRow == x && currentCol == y) {
                return currentCost; // Reached destination, return the cost
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    int newCost = currentCost + (dir[0] != 0 ? 1 : 0); // Adding cost for up/down movement

                    queue.offer(new Cell(newRow, newCol, newCost));
                }
            }
        }

        return -1;
    }
}
