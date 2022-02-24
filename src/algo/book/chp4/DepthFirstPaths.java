package algo.book.chp4;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        source = s;
        dfs(G, source);
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
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
}
