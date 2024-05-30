import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        int[][] adjacencyMatrix = new int[numVertices][numVertices];

        System.out.println("Enter the edges in the format \"source target\" (one edge per line):");
        for (int i = 0; i < numEdges; i++) {
            int sourceVertex = scanner.nextInt();
            int targetVertex = scanner.nextInt();
            adjacencyMatrix[sourceVertex][targetVertex]++;
        }

        System.out.println("The adjacency matrix is:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

/*
Test case 1:
Enter the number of vertices:
3
Enter the number of edges:
4
Enter the edges in the format "source target" (one edge per line):
0 1
0 1
1 2
2 0

Test case 2:
Enter the number of vertices:
3
Enter the number of edges:
3
Enter the edges in the format "source target" (one edge per line):
0 0
1 2
2 1

Test case 3:
Enter the number of vertices:
4
Enter the number of edges:
4
Enter the edges in the format "source target" (one edge per line):
0 1
1 2
2 3
3 0

Test case 4:
Enter the number of vertices:
4
Enter the number of edges:
2
Enter the edges in the format "source target" (one edge per line):
0 1
2 3

Test case 5:
Enter the number of vertices:
4
Enter the number of edges:
0
Enter the edges in the format "source target" (one edge per line):
 */
