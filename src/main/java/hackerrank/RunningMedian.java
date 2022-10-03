package hackerrank;

import java.util.List;
import java.util.PriorityQueue;

public final class RunningMedian {

    public static void main(String[] args) {
        runningMedian(List.of(12, 4, 5, 3, 8, 7).stream().mapToInt(i -> i).toArray());
    }

    public static double[] runningMedian(int[] items) {
        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        double[] medians = new double[items.length];

        for (int i = 0; i < items.length; i++) {
            addItem(items[i], lower, higher);
            rebalanceHeaps(lower, higher);
            medians[i] = getMedian(lower, higher);
        }
        return medians;
    }

    private static void addItem(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() == 0 || number < lower.peek())
            lower.offer(number);
        else
            higher.offer(number);
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() - smallerHeap.size() >= 2)
            smallerHeap.offer(biggerHeap.poll());
    }

    private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else
            return biggerHeap.peek();
    }
}
