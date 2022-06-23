package hackerrank.disjointSet;

import java.util.Arrays;
import java.util.List;

// https://www.kaggle.com/code/robonimo86/disjoint-set-data-structure-for-component-size/notebook
public class ComponentsInAGraph {
    private int[] parent;  // parent[i] = parent of i
    private int[] size;

    public static void main(String[] args) {
        ComponentsInAGraph c = new ComponentsInAGraph();
//        c.componentsInGraph(5, List.of(List.of(1, 5), List.of(1, 6), List.of(2, 4)));
        c.componentsInGraph(5, List.of(List.of(1, 6), List.of(2, 7), List.of(3, 8), List.of(4, 9), List.of(2, 6)));
//        c.componentsInGraph(10, List.of(List.of(1, 17), List.of(5, 13), List.of(7, 12), List.of(5, 17), List.of(5, 12),
//            List.of(2, 17), List.of(1, 18), List.of(8, 13), List.of(2, 15), List.of(5, 20)));
    }

    public List<Integer> componentsInGraph(int n, List<List<Integer>> gb) {
        int nNodes = 2 * n;
        parent = new int[nNodes + 1];
        size = new int[nNodes + 1];

        for (int i = 1; i <= nNodes; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (List<Integer> item : gb) {
            int rootP = find(item.get(0));
            int rootQ = find(item.get(1));
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
                size[rootP] = 0;
            }
        }
        int highestValue = Arrays.stream(size).boxed().mapToInt(v -> v).max().getAsInt();
        int lowestValue = Arrays.stream(size).boxed().filter(v -> v > 1).mapToInt(v -> v).min().getAsInt();
        return List.of(lowestValue, highestValue);
    }

    private int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }


}
