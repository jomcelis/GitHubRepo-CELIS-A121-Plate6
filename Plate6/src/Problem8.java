import java.util.Arrays;

public class Problem8 {

    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        if (graph2.length != n) return false;

        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) permutation[i] = i;

        return checkIsomorphism(graph1, graph2, permutation, 0);
    }

    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] permutation, int index) {
        if (index == permutation.length) {
            return arePermutedGraphsSame(graph1, graph2, permutation);
        }

        for (int i = index; i < permutation.length; i++) {
            swap(permutation, index, i);
            if (checkIsomorphism(graph1, graph2, permutation, index + 1)) {
                return true;
            }
            swap(permutation, index, i);
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean arePermutedGraphsSame(int[][] graph1, int[][] graph2, int[] permutation) {
        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1.length; j++) {
                if (graph1[i][j] != graph2[permutation[i]][permutation[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph1 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        int[][] graph2 = {
                {0, 1, 1},
                {1, 0, 0},
                {1, 0, 0}
        };

        int[][] graph3 = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        int[][] graph4 = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        int[][] graph5 = {
                {0, 1},
                {1, 0}
        };

        int[][] graph6 = {
                {0, 1},
                {1, 0}
        };

        int[][] graph7 = {
                {0, 1},
                {0, 0}
        };

        int[][] graph8 = {
                {0, 1, 0},
                {1, 0, 0},
                {0, 0, 0}
        };

        int[][] graph9 = {
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 0}
        };

        System.out.println("Test Case 1: " + areIsomorphic(graph1, graph2)); // false
        System.out.println("Test Case 2: " + areIsomorphic(graph1, graph3)); // true
        System.out.println("Test Case 3: " + areIsomorphic(graph1, graph4)); // false
        System.out.println("Test Case 4: " + areIsomorphic(graph5, graph6)); // true
        System.out.println("Test Case 5: " + areIsomorphic(graph8, graph9)); // false
    }
}
