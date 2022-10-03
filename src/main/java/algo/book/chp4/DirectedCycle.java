package algo.book.chp4;

import edu.princeton.cs.algorithms.Stack;

public final class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        onStack = new boolean[G.V()];
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    private void dfs(Graph G, int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (hasCycle())
                return;
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(13);
        d.addEdge(0, 1);
        d.addEdge(0, 5);
        d.addEdge(2, 0);
        d.addEdge(2, 3);
        d.addEdge(3, 2);
        d.addEdge(3, 5);
        d.addEdge(4, 2);
        d.addEdge(4, 3);
        d.addEdge(5, 4);
        d.addEdge(6, 0);
        d.addEdge(6, 4);
        d.addEdge(6, 8);
        d.addEdge(6, 9);
        d.addEdge(7, 6);
        d.addEdge(7, 9);
        d.addEdge(8, 6);
        d.addEdge(9, 10);
        d.addEdge(9, 11);
        d.addEdge(10, 12);
        d.addEdge(4, 2);
        d.addEdge(11, 4);
        d.addEdge(11, 12);
        d.addEdge(12, 9);
    }
}
