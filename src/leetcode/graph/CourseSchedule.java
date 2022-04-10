package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;
    private Stack<Integer> reversePost;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
                return true;

        List<LinkedList<Integer>> adjacencyMatrix = new ArrayList<>();
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        edgeTo = new int[numCourses];
        reversePost = new Stack<>();

        for (int i = 0; i < numCourses; i++)
            adjacencyMatrix.add(new LinkedList<>());

        for (int[] edge : prerequisites)
            adjacencyMatrix.get(edge[1]).add(edge[0]);

        for (int i = 0; i < numCourses; i++)
            if (!marked[i])
                dfs(i, adjacencyMatrix);

        for (int i = 0; i < numCourses; i++)
            if (!marked[i])
                return false;

        return !hasCycle();
    }

    private void dfs(int v, List<LinkedList<Integer>> adjacencyMatrix) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : adjacencyMatrix.get(v)) {
            if (hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w, adjacencyMatrix);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int i = v; i != w; i = edgeTo[i])
                    cycle.push(i);
                cycle.push(w);
            }
        }
        reversePost.push(v);
        onStack[v] = false;
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePost;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = new int[][]{
                {0, 2},
                {1, 0},
                {3, 2},
                {2, 3},
                {4, 5},
                {4, 6},
                {5, 0},
                {5, 3},
                {6, 0},
                {6, 7},
                {7, 8},
                {9, 6},
                {10, 9},
                {11, 9},
                {12, 9},
                {12, 11}
        };
        System.out.println(cs.canFinish(13, prerequisites));
    }
}
