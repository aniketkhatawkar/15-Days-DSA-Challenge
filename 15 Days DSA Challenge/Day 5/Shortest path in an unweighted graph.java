import java.util.*;

public class Main {
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0] - 1;
            int v = edges[i][1] - 1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        queue.add(s - 1);
        visited[s - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        LinkedList<Integer> shortestPath = new LinkedList<>();
        int current = t - 1;
        while (current != -1) {
            shortestPath.addFirst(current + 1); 
            current = parent[current];
        }

        return shortestPath;
    }

    public static void main(String[] args) {
        // Sample input
        int[][] edges1 = {{1, 4}, {1, 2}, {2, 3}, {3, 4}};
        int n1 = 4;
        int m1 = 4;
        int s1 = 1;
        int t1 = 4;

        LinkedList<Integer> path1 = shortestPath(edges1, n1, m1, s1, t1);
        System.out.println("Sample Output 1:");
        System.out.println(path1);

        int[][] edges2 = {{1, 8}, {1, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 8}, {3, 8}, {4, 6}, {6, 7}, {7, 8}};
        int n2 = 8;
        int m2 = 9;
        int s2 = 1;
        int t2 = 8;

        LinkedList<Integer> path2 = shortestPath(edges2, n2, m2, s2, t2);
        System.out.println("Sample Output 2:");
        System.out.println(path2);
    }
}
