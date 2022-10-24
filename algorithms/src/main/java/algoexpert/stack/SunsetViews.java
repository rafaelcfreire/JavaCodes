package algoexpert.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class SunsetViews {
    public static List<Integer> sunsetViews(int[] buildings, String direction) {
        Deque<Integer> stack = new ArrayDeque<>();
        int startIdx = 0;
        int step = 1;

        if (!direction.equals("EAST")) {
            startIdx = buildings.length - 1;
            step = -1;
        }
        int idx = startIdx;

        while (idx >= 0 && idx < buildings.length) {
            if (!stack.isEmpty()) {
                int node = stack.peek();

                while (node != -1 && buildings[idx] >= buildings[node]) {
                    stack.pop();
                    if (!stack.isEmpty())
                        node = stack.peek();
                    else
                        node = -1;
                }
            }
            stack.push(idx);
            idx += step;
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            if (direction.equals("EAST"))
                result.add(stack.removeLast());
            else
                result.add(stack.removeFirst());
        }
        return result;
    }

    public static void main(String[] args) {
        sunsetViews(new int[]{3, 5, 4, 4, 3, 1, 3, 2}, "EAST");
    }
}
