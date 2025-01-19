package sedgewick.chp4;

final class ConnectPoints {
    private int[][] adjacencyMatrix;
    private final int N_VERTEX;
    private final int MAX_CONNECTIONS;
    public ConnectPoints(int nVertex, int maxConnections) {
        adjacencyMatrix = new int[nVertex][nVertex];
        N_VERTEX = nVertex;
        MAX_CONNECTIONS = maxConnections;
        connectVertex(0);
    }

    public void connectVertex(int initialVertice) {
        boolean success = backtracking(initialVertice);
        System.out.println(success);
    }

    private boolean backtracking(int v) {
        if (N_VERTEX == v) {
            return allPointsConnected();
        }

        for (int w = 0; w < N_VERTEX; w++) {
            if (canAddConnection(v, w)) {
                adjacencyMatrix[v][w] = 1;
                adjacencyMatrix[w][v] = 1;

                if (backtracking(v + 1)) {
                    return true;
                }

                adjacencyMatrix[v][w] = 0;
                adjacencyMatrix[w][v] = 0;
            }
        }
        return false;
    }

    private boolean canAddConnection(int v, int w) {
        if (v == w) {
            return false;
        }
        if (adjacencyMatrix[v][w] == 1) {
            return false;
        }
        if (countConnections(v) >= MAX_CONNECTIONS || countConnections(w) >= MAX_CONNECTIONS) {
            return false;
        }
        return true;
    }

    private boolean allPointsConnected() {
        for (int i = 0; i < N_VERTEX; i++) {
            if (countConnections(i) != MAX_CONNECTIONS) {
                return false;
            }
        }
        return true;
    }

    private int countConnections(int vertice) {
        int count = 0;
        for (int i = 0; i < N_VERTEX; i++) {
            if (adjacencyMatrix[vertice][i] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ConnectPoints connectPoints = new ConnectPoints(10, 5);
    }
}