import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of edges
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        // Map to store the degree of each vertex
        Map<Integer, Integer> degreeMap = new HashMap<>();

        // Read the edges and calculate the degrees
        System.out.println("Enter the edges: ");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Increment the degree for both vertices
            degreeMap.put(vertex1, degreeMap.getOrDefault(vertex1, 0) + 1);
            degreeMap.put(vertex2, degreeMap.getOrDefault(vertex2, 0) + 1);
        }

        // Output the degree of each vertex
        System.out.println("Degrees of vertices:");
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}

/*
Test Case 1:
Number of edges: 3
Edges:
0 1
0 2
1 2

Test Case 2:
Number of edges: 4
Edges:
1 2
2 3
3 4
4 1

Test Case 3:
Number of edges: 5
Edges:
0 1
1 2
2 3
3 4
4 0

Test Case 4:
Number of edges: 5
Edges:
0 1
1 2
2 3
3 4
4 0

Test Case 5:
Number of edges: 1
Edges:
3 4

 */
