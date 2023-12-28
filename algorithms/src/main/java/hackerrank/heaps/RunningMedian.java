package hackerrank.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public final class RunningMedian {
    public static void main(String[] args) {
//        runningMedian(List.of(7, 3, 5, 2));
        runningMedian(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static List<Double> runningMedian(List<Integer> a) {
        PriorityQueue<Double> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> higher = new PriorityQueue<>();
        List<Double> result = new ArrayList<>();

        for (int curr : a) {
            if (lower.isEmpty() || curr < lower.peek())
                lower.add(Double.valueOf(curr));
            else
                higher.add(Double.valueOf(curr));

            if (lower.size() - higher.size() == 2)
                higher.add(lower.poll());
            else if (higher.size() - lower.size() == 2)
                lower.add(higher.poll());
            addMedian(lower, higher, result);
        }
        return result;
    }

    private static void addMedian(final PriorityQueue<Double> lower, final PriorityQueue<Double> higher, final List<Double> result) {
        if (lower.size() == higher.size())
            result.add((lower.peek() + higher.peek())/2);
        else if (lower.size() > higher.size())
            result.add(lower.peek());
        else
            result.add(higher.peek());
    }


}
