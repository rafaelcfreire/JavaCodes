package leetcode.graph;

// https://leetcode.com/problems/is-graph-bipartite/
final class BipartiteGraph {

    private static boolean isBipartite;

    public static void main(String[] args) {
//        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0,2}}));
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0,2}}));
        System.out.println(isBipartite(new int[][]{{2,3,5,6,7,8,9}, {2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},{0,1,2,4,5,6,7,8,9}, {1,2,3,6,9},
                {0,1,2,3,7,8,9},{0,1,2,3,4,7,8,9},{0,1,2,3,5,6,8,9},{0,1,2,3,5,6,7},{0,1,2,3,4,5,6,7}}));
        System.out.println(isBipartite(new int[][]{{3,4,6}, {3,6},{3,6},{0,1,2,5},{0,7,8},{3},{0,1,2,7},{4,6},{4},{}}));
    }

    public static boolean isBipartite(int[][] graph) {
        isBipartite = true;
        int nVertex = graph.length;
        boolean[] marked = new boolean[nVertex];
        boolean[] color = new boolean[nVertex];

        for (int i = 0; i < nVertex; i++)
            if (!marked[i]) {
                dfs(graph, marked, color, i);
            }
        return isBipartite;
    }

    private static void dfs(int[][] graph, boolean[] marked, boolean[] color, int i) {
        marked[i] = true;
        for (int v : graph[i]) {
            if (!marked[v]) {
                color[v] = !color[i];
                 dfs(graph, marked, color, v);
            } else if (color[v] == color[i])
                isBipartite = false;
        }
    }
}
