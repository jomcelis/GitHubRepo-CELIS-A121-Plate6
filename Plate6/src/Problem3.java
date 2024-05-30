import java.util.*;

public class Problem3 {

    // Method to check if the graph contains a cycle
    public static boolean hasCycle(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (hasCycleUtil(adjacencyMatrix, i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    // Utility method to perform DFS and detect cycle
    private static boolean hasCycleUtil(int[][] adjacencyMatrix, int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true; // If the node is already in the recursion stack, a cycle is detected
        }
        if (visited[v]) {
            return false; // If the node is already visited and not in the recursion stack, no cycle
        }

        visited[v] = true;
        recStack[v] = true;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[v][i] != 0 && hasCycleUtil(adjacencyMatrix, i, visited, recStack)) {
                return true;
            }
        }

        recStack[v] = false; // Remove the node from recursion stack before returning
        return false;
    }

    public static void main(String[] args) {
        // Test inputs
        int[][] test1 = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        int[][] test2 = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        int[][] test3 = {
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int[][] test4 = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        int[][] test5 = {
                {0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        System.out.println("Test 1 has cycle: " + hasCycle(test1)); // True
        System.out.println("Test 2 has cycle: " + hasCycle(test2)); // False
        System.out.println("Test 3 has cycle: " + hasCycle(test3)); // False
        System.out.println("Test 4 has cycle: " + hasCycle(test4)); // True
        System.out.println("Test 5 has cycle: " + hasCycle(test5)); // False
    }
}
