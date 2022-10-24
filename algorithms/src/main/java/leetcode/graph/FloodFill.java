package leetcode.graph;

// https://leetcode.com/problems/flood-fill/
public final class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][] {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        floodFill(image, 1, 1, 2);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];



        return image;
    }
}
