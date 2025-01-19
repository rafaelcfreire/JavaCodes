package leetcode.unionfind;

//https://leetcode.com/problems/number-of-provinces/
final class NumberOfProvinces {
    private int[] id = null;
    private int provinces = 0;
    public int findCircleNum(int[][] isConnected) {
        provinces = isConnected.length;
        id = new int[provinces + 1];

        for (int i = 1; i <= provinces; i++) {
            id[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            union(isConnected[i], i + 1);
        }
        return provinces;
    }

    private void union(int[] connections, int currentCity) {
        for (int l = 0; l < connections.length; l++) {
            if (l + 1 != currentCity && connections[l] == 1) {
                int i = find(l + 1);
                int j = find(currentCity);

                if (i != j) {
                    id[i] = j;
                    provinces--;
                }
            }
        }
    }

    private int find(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        np.findCircleNum(new int[][]{{1,1,0}, {1,1,0}, {0,0,1}});
        np.findCircleNum(new int[][]{{1,0,0}, {0,1,0}, {0,0,1}});
        np.findCircleNum(new int[][] {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}});
    }
}