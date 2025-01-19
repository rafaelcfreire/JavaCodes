package sedgewick.chp4;

import java.util.Stack;

public final class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        source = s;
        dfsNonRecursive(G, source);
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }

    public void dfsNonRecursive(Graph G, int v) {
        Stack<Integer> stack = new Stack<>();
        marked[v] = true;
        stack.push(v);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int w : G.adj(node)) {
                if (!marked[w]) {
                    edgeTo[w] = node;
                    marked[w] = true;
                    stack.push(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(v);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(1, 4);
        graph.addEdge(1, 5);

        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        graph.addEdge(5, 8);
        graph.addEdge(5, 9);

        graph.addEdge(6, 10);

        DepthFirstPaths dfp = new DepthFirstPaths(graph, 0);
    }
}
