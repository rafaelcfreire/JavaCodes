package hackerrank.balancedtrees;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianUpdates {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        if (n < 1 || n > 100000) {
            throw new IllegalArgumentException("1 <= n <= 100000");
        }

        DecimalFormat fmt = new DecimalFormat("#.#") ;
        Set set = new Set();
        for (int i = 0; i < n; i++) {
            String operation = scanner.next();
            if (operation.equals("a")) {
                set.addNum(scanner.nextInt());
            } else if (operation.equals("r")) {
                if (!set.removeNum(scanner.nextInt())) {
                    System.out.println("Wrong!");
                    continue;
                }
            } else {
                throw new IllegalArgumentException("Operation must be a or r");
            }
            Double median = set.getMedian();
            if (median != null) {
                System.out.println(fmt.format(median));
            } else {
                System.out.println("Wrong!");
            }
        }
    }

//    public static void main(String[] args) {
//        Set set = new Set();
//        System.out.println(set.removeNum(1));
//        set.addNum(1);
//        System.out.println(set.getMedian());
//        set.addNum(2);
//        System.out.println(set.getMedian());
//        set.addNum(1);
//        System.out.println(set.getMedian());
//        System.out.println(set.removeNum(1));
//        System.out.println(set.getMedian());
//        System.out.println(set.removeNum(2));
//        System.out.println(set.getMedian());
//        System.out.println(set.removeNum(1));
//        System.out.println(set.getMedian());
//    }

    private static class Set {
        private PriorityQueue<Integer> minPq = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> maxPq = new PriorityQueue<>();

        public void addNum(int number) {
            if (minPq.isEmpty() || number <= minPq.peek())
                minPq.add(number);
            else
                maxPq.add(number);
            rebalanceHeaps();
        }

        private void rebalanceHeaps() {
            if (minPq.size() - maxPq.size() == 2)
                maxPq.add(minPq.poll());
            else if (maxPq.size() - minPq.size() == 2)
                minPq.add(maxPq.poll());
        }

        public boolean removeNum(int number) {
            if (minPq.isEmpty() && maxPq.isEmpty())
                return false;

            if (number <= minPq.peek())
                return minPq.remove(Integer.valueOf(number));
            else
                return maxPq.remove(Integer.valueOf(number));
        }

        public Double getMedian() {
            if (minPq.isEmpty() && maxPq.isEmpty())
                return null;
            if (minPq.size() == maxPq.size())
                return ((double)minPq.peek() + (double)maxPq.peek()) / 2;
            else if (minPq.size() > maxPq.size())
                return (double) minPq.peek();
            else
                return (double) maxPq.peek();
        }
    }


}
