package sedgewick.chp4;

public class PointConnections {
    // Constants for the number of points and the maximum connections
    static final int NUM_POINTS = 3;
    static final int MAX_CONNECTIONS = 2;

    // Adjacency matrix to store connections between points
    static int[][] adjacencyMatrix = new int[NUM_POINTS][NUM_POINTS];

    public static void main(String[] args) {
        double sum = 0.0;
        for (int i = 1; i < 100; i++) {
            sum += 1 / (i * (i + 1.0));
        }
        System.out.println(sum);
        // Initialize the adjacency matrix with all 0s
//        for (int i = 0; i < NUM_POINTS; i++) {
//            for (int j = 0; j < NUM_POINTS; j++) {
//                adjacencyMatrix[i][j] = 0;
//            }
//        }
//
//        // Start the backtracking process from the first point
//        if (backtrack(0)) {
//            System.out.println("Solution found:");
//            printConnections();
//        } else {
//            System.out.println("No solution found.");
//        }
    }

    // Backtracking function to build the connections
    static boolean backtrack(int point) {
        // If all points are processed, check if all have exactly 5 connections
        if (point == NUM_POINTS) {
            return allPointsConnected();
        }

        // Try connecting the current point to other points
        for (int otherPoint = 0; otherPoint < NUM_POINTS; otherPoint++) {
            // Check if we can add a connection between point and otherPoint
            if (canAddConnection(point, otherPoint)) {
                // Add the connection
                adjacencyMatrix[point][otherPoint] = 1;
                adjacencyMatrix[otherPoint][point] = 1;

                // Recur to process the next point
                if (backtrack(point + 1)) {
                    return true;
                }

                // Backtrack: Undo the connection if the recursion fails
                adjacencyMatrix[point][otherPoint] = 0;
                adjacencyMatrix[otherPoint][point] = 0;
            }
        }

        // If no valid connection can be made, backtrack
        return false;
    }

    // Function to check if we can add a connection between two points
    static boolean canAddConnection(int i, int j) {
        // A point cannot connect to itself
        if (i == j) {
            return false;
        }
        // Check if the connection already exists
        if (adjacencyMatrix[i][j] == 1) {
            return false;
        }
        // Check if either point has reached the maximum number of connections
        if (countConnections(i) >= MAX_CONNECTIONS || countConnections(j) >= MAX_CONNECTIONS) {
            return false;
        }
        return true;
    }

    // Function to count how many connections a point currently has
    static int countConnections(int point) {
        int count = 0;
        for (int k = 0; k < NUM_POINTS; k++) {
            if (adjacencyMatrix[point][k] == 1) {
                count++;
            }
        }
        return count;
    }

    // Function to check if all points have exactly 5 connections
    static boolean allPointsConnected() {
        for (int i = 0; i < NUM_POINTS; i++) {
            if (countConnections(i) != MAX_CONNECTIONS) {
                return false;
            }
        }
        return true;
    }

    // Function to print the adjacency matrix (connections between points)
    static void printConnections() {
        for (int i = 0; i < NUM_POINTS; i++) {
            System.out.print("Point " + i + " is connected to: ");
            for (int j = 0; j < NUM_POINTS; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}