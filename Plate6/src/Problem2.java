import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        Map<String, Integer> edgeCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i + "-" + j;
                    edgeCountMap.put(edge, adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}


/*
Test input 1:
4
0 1 2 0
1 0 1 3
2 1 0 0
0 3 0 0

Test input 2:
4
0 2 0 1
2 0 3 0
0 3 0 4
1 0 4 0

Test input 3:
4
0 1 1 0
1 0 1 1
1 1 0 1
0 1 1 0

Test input 4:
5
0 0 0 0 0
0 0 2 0 0
0 2 0 1 0
0 0 1 0 3
Test input 5
6
0 0 0 0 0 1
0 0 2 0 0 0
0 2 0 0 0 1
0 0 0 0 3 0
0 0 0 3 0 4
1 0 1 0 4 0
 */

