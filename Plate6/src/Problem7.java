import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> vertexMap = new HashMap<>();
        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges and their counts:");
        for (int i = 0; i < numEdges; i++) {
            String vertex1 = scanner.next();
            String vertex2 = scanner.next();
            int count = scanner.nextInt();
            edges.add(new Edge(vertex1, vertex2, count));

            if (!vertexMap.containsKey(vertex1)) {
                vertexMap.put(vertex1, vertexMap.size());
            }
            if (!vertexMap.containsKey(vertex2)) {
                vertexMap.put(vertex2, vertexMap.size());
            }
        }

        int numVertices = vertexMap.size();
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            int v1 = vertexMap.get(edge.vertex1);
            int v2 = vertexMap.get(edge.vertex2);
            incidenceMatrix[v1][i] = edge.count;
            incidenceMatrix[v2][i] = edge.count;
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Edge {
    String vertex1;
    String vertex2;
    int count;

    Edge(String vertex1, String vertex2, int count) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.count = count;
    }
}

/*
Test case 1:
5
A B 1
A C 2
B C 1
B D 2
C D 1

Test case 2:
4
X Y 1
Y Z 2
Z X 1
W X 1

Test case 3:
3
P Q 3
Q R 2
P R 1

Test case 4:
2
M N 2
N O 3

Test case 5:
1
A B 5

 */

