package algoexpert.graphs;

public final class CycleInGraph {

// FIRST SOLUTION
//    public static boolean cycleInGraph(int[][] edges) {
//        boolean[] visited = new boolean[edges.length];
//        boolean[] currentlyInStack = new boolean[edges.length];
//
//        for (int node = 0; node < edges.length; node++) {
//            boolean containsCycle = isNodeInCycle(node, edges, visited, currentlyInStack);
//            if (containsCycle)
//                return true;
//            if (currentlyInStack[node])
//                return true;
//        }
//        return false;
//    }
//
//    private static boolean isNodeInCycle(int node, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
//        visited[node] = true;
//        currentlyInStack[node] = true;
//
//        boolean containsCycle = false;
//        int[] neighbors = edges[node];
//
//        for (int neighbor : neighbors) {
//            if (!visited[neighbor])
//                containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
//            if (containsCycle)
//                return true;
//            else if (currentlyInStack[node])
//                return true;
//        }
//        currentlyInStack[node] = false;
//        return false;
//    }
    private static int WHITE = 0;
    private static int GREY = 1;
    private static int BLACK = 2;

    public static boolean cycleInGraph(int[][] edges) {
        int colors[] = new int[edges.length];

        for (int node = 0; node < edges.length; node++) {
            boolean containsCycle = traverseColorNodes(node, edges, colors);

            if (containsCycle)
                return true;
        }
        return false;
    }

    private static boolean traverseColorNodes(int node, int[][] edges, int[] colors) {
        int[] neighbors = edges[node];
        colors[node] = GREY;

        for (int neighbor : neighbors) {
            if (colors[neighbor] == GREY)
                return true;

            boolean containsCycle = traverseColorNodes(neighbor, edges, colors);
            if (containsCycle)
                return true;
        }
        colors[node] = BLACK;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {
            {1, 3},
            {2, 3, 4},
            {0},
            {},
            {2, 5},
            {}
        };
        boolean result = cycleInGraph(edges);
    }
}
