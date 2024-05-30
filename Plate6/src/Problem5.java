import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        List<Edge> edgeList = new ArrayList<>();
        System.out.println("Enter the edges in the format:");
        for (int i = 0; i < numEdges; i++) {
            int sourceVertex = scanner.nextInt();
            int targetVertex = scanner.nextInt();
            edgeList.add(new Edge(sourceVertex, targetVertex));
        }
        boolean isBipartiteGraph = checkIfBipartite(edgeList);
        if (isBipartiteGraph) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }
        scanner.close();
    }

    static class Edge {
        int sourceVertex;
        int targetVertex;

        public Edge(int sourceVertex, int targetVertex) {
            this.sourceVertex = sourceVertex;
            this.targetVertex = targetVertex;
        }

        public String toString() {
            return sourceVertex + " -> " + targetVertex;
        }
    }

    static boolean checkIfBipartite(List<Edge> edgeList) {
        Map<Integer, Integer> vertexColorMap = new HashMap<>();
        for (Edge edge : edgeList) {
            int sourceVertex = edge.sourceVertex;
            int targetVertex = edge.targetVertex;
            if (vertexColorMap.containsKey(sourceVertex) && vertexColorMap.get(sourceVertex).equals(vertexColorMap.get(targetVertex))) {
                return false;
            }
            vertexColorMap.put(sourceVertex, -1 * getVertexColor(vertexColorMap, targetVertex));
            vertexColorMap.put(targetVertex, getVertexColor(vertexColorMap, sourceVertex));
        }
        return true;
    }

    static int getVertexColor(Map<Integer, Integer> vertexColorMap, int vertex) {
        return vertexColorMap.containsKey(vertex) ? vertexColorMap.get(vertex) : 1;
    }
}

/*

Test case 1
Enter the number of edges:
4
Enter the edges in the format "source target" (one edge per line):
0 1
0 3
2 1
2 3

Test case 2:
Enter the number of edges:
3
Enter the edges in the format "source target" (one edge per line):
0 1
1 2
2 0

Test case 3:
Enter the number of edges:
5
Enter the edges in the format "source target" (one edge per line):
0 1
0 2
1 3
2 3
3 4

Test case 4:
Enter the number of edges:
1
Enter the edges in the format "source target" (one edge per line):
0 1

Test case 5:
Enter the number of edges:
4
Enter the edges in the format "source target" (one edge per line):
0 1
2 3
4 5
5 6

 */
