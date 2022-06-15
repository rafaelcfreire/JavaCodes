package algo.book.chp4.mst;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {
    private double weight;
    private Queue<Edge> mst = new Queue<>();
    PriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G) {
        List<Edge> edges = new ArrayList<>();
        for (Edge e : G.edges()) {
            edges.add(e);
        }

        pq = new PriorityQueue<>(edges);
        UF uf = new UF(G.V());
        for (int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            // v-w does not create a cycle
            if (uf.find(v) != uf.find(w)) {
                uf.union(v, w);     // merge v and w components
                mst.enqueue(e);     // add edge e to mst
                weight += e.weight();
            }
        }

    }
}
