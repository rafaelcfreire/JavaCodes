package princeton.week1;

public final class UnionFind {
    private int[] id;
    private int[] sz;
    private int count;
    private int[] max;

    public UnionFind(int n) {
        count = n;

        id = new int[n];
        sz = new int[n];
        max = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            max[i] = i;
        }
    }

    public int count() {
        return count;
    }

    //Iterates until find a node which has a link to itself
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public int getMax(int i) {
        return max[find(i)];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            max[j] = max[i] > max[j] ? max[i] : max[j];
        } else {
            id[j] = i;
            sz[i] += sz[j];
            max[i] = max[j] > max[i] ? max[j] : max[i];
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);
        uf.union(1, 6);
        uf.union(1, 9);
        uf.getMax(1);
    }
}
