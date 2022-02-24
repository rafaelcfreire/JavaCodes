package leetcode.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> lower;
    private PriorityQueue<Integer> higher;

    public MedianFinder() {
        lower = new PriorityQueue<>((a, b) -> b - a);
        higher = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (lower.size() == 0 || num < lower.peek())
            lower.offer(num);
        else
            higher.offer(num);
        rebalanceHeaps(lower, higher);
    }

    public double findMedian() {
        if (lower.size() > higher.size())
            return lower.peek();
        else if (higher.size() > lower.size())
            return higher.peek();
        else
            return (lower.peek()+ higher.peek()) / 2.0;
    }

    private void rebalanceHeaps(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
        if (lower.size() - higher.size() >= 2)
            higher.offer((lower.poll()));
        else if (higher.size() - lower.size() >= 2)
            lower.offer(higher.poll());
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(5);
        medianFinder.addNum(10);
        medianFinder.addNum(100);
        medianFinder.addNum(200);
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(13);
        System.out.println(medianFinder.findMedian());
    }
}
