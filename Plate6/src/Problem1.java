import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> graph = new ArrayList<>();

        System.out.println("Enter the edges of the graph in the format 'u v', where u and v are vertices");
        System.out.println("Enter a blank line to finish");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] vertices = line.split("\\s+");
            int vertex1 = Integer.parseInt(vertices[0]);
            int vertex2 = Integer.parseInt(vertices[1]);
            while (graph.size() <= vertex1 || graph.size() <= vertex2) {
                graph.add(new ArrayList<>());
            }
            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        boolean[] visitedVertices = new boolean[graph.size()];
        int connectedComponentsCount = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!visitedVertices[i]) {
                connectedComponentsCount++;
                performDFS(graph, visitedVertices, i);
            }
        }

        if (connectedComponentsCount == 1) {
            System.out.println("The graph is connected");
        } else {
            System.out.println("The graph is not connected");
            System.out.println("The number of connected components is " + connectedComponentsCount);
        }

        scanner.close();
    }

    private static void performDFS(List<List<Integer>> graph, boolean[] visitedVertices, int currentVertex) {
        visitedVertices[currentVertex] = true;
        for (int neighbor : graph.get(currentVertex)) {
            if (!visitedVertices[neighbor]) {
                performDFS(graph, visitedVertices, neighbor);
            }
        }
    }
}
