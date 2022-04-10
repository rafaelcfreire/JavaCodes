package leetcode.graph;

import edu.princeton.cs.algs4.Cycle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    private int[] edgeTo;
    private boolean[] visited;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    private Stack<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] returnValue = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                returnValue[i] = i;
        }

        List<LinkedList<Integer>> adjacencyMatrix = new ArrayList<>();
        edgeTo = new int[numCourses];
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        postOrder = new Stack<>();

        for (int i = 0; i < numCourses; i++)
            adjacencyMatrix.add(new LinkedList<>());

        for (int[] edge : prerequisites)
            adjacencyMatrix.get(edge[1]).add(edge[0]);

        for (int i = 0; i < numCourses; i++)
            if (!visited[i])
                dfs(i, adjacencyMatrix);

        if (hasCycle())
            return new int[]{};
        else {
            int[] returnValue = new int[numCourses];
            for (int i = 0; i < numCourses; i++)
                returnValue[i] = postOrder.pop();
            return returnValue;
        }
    }

    private void dfs(int v, List<LinkedList<Integer>> adjacencyMatrix) {
        onStack[v] = true;
        visited[v] = true;

        for (int w : adjacencyMatrix.get(v)) {
            if (hasCycle()) {
                return;
            } else if (!visited[w]) {
                edgeTo[w] = v;
                dfs(w, adjacencyMatrix);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i])
                    cycle.add(i);
                cycle.push(w);
            }
        }
        postOrder.push(v);
        onStack[v] = false;
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    public static void main(String[] args) {
        CourseScheduleII cs = new CourseScheduleII();
//        int[][] prerequisites = new int[][]{
//                {0, 2},
//                {1, 0},
//                {3, 2},
//                {4, 5},
//                {4, 6},
//                {5, 0},
//                {5, 3},
//                {6, 0},
//                {6, 7},
//                {7, 8},
//                {9, 6},
//                {10, 9},
//                {11, 9},
//                {12, 9},
//                {12, 11}
//        };
//        int[] result = cs.findOrder(13, prerequisites);
        int[][] prerequisites = new int[][] {
                {1, 0},
                {0, 2},
                {2, 1}
        };
        int[] result = cs.findOrder(3, prerequisites);
        for (int value : result)
            System.out.print(" "+value);

    }
}
