package hackerrank.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public final class MinimumAverageTime {

    public static void main(String[] args) {
//        System.out.println(minimumAverage(new ArrayList<>(Arrays.asList(List.of(0, 3), List.of(3, 9), List.of(2, 6)))));
//        System.out.println(minimumAverage(List.of(List.of(0, 3), List.of(1, 9), List.of(2, 5))));
        System.out.println(minimumAverage(List.of(List.of(961148050, 385599125), List.of(951133776, 376367013), List.of(283280121, 782916802),
            List.of(317664929, 898415172), List.of(980913391, 847912645))));
    }

    public static long minimumAverage(List<List<Integer>> customers) {
        List<Customer> orderedCustomers = new ArrayList<>();

        for (List<Integer> curr : customers)
            orderedCustomers.add(new Customer(curr.get(0), curr.get(1)));
        orderedCustomers = orderedCustomers.stream().sorted((o1, o2) -> o1.startTime - o2.startTime).collect(Collectors.toList());

        PriorityQueue<Customer> pq = new PriorityQueue<>();
        long totalTime = 0;
        long currTime = 0;
        int index = 0;

        while (index < orderedCustomers.size() || !pq.isEmpty()) {
            while (index < orderedCustomers.size() && orderedCustomers.get(index).startTime <= currTime) {
                pq.add(orderedCustomers.get(index));
                index++;
            }
            if (!pq.isEmpty()) {
                Customer curr = pq.poll();
                currTime += curr.cookTime;
                totalTime += currTime - curr.startTime;
            } else
                currTime = orderedCustomers.get(index).startTime;
        }

        return totalTime / customers.size();
    }

    private static class Customer implements Comparable<Customer> {
        private Integer startTime;
        private Integer cookTime;

        public Customer(int startTime, int timeNeeded) {
            this.startTime = startTime;
            this.cookTime = timeNeeded;
        }

        @Override
        public int compareTo(Customer other) {
            return this.cookTime - other.cookTime;
        }
    }

}
