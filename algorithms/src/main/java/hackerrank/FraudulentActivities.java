package hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem

public final class FraudulentActivities {
    public static void main(String[] args) throws Exception {
        File f = new File("files/fraudulentActivities");
        BufferedReader b = new BufferedReader(new FileReader(f));
        String temp1 = b.readLine();

        System.out.println(

                // Result = 633
//               activityNotifications(
//                        Arrays.stream(temp1.split(" ")).map(Integer::valueOf).toArray(Integer[]::new), 10000
//                )

//                activityNotifications(List.of(10, 20, 30, 40, 50).toArray(Integer[]::new), 3)
//                activityNotifications(List.of(2, 3, 4, 2, 3, 6, 8, 4, 5).toArray(Integer[]::new), 5)
                //activityNotifications(List.of(10, 7, 12, 4, 9, 13).toArray(Integer[]::new), 6)
        );
        //Instant end = Instant.now();
        //System.out.println(Duration.between(start, end));
    }

    static int activityNotifications(Integer[] expenditure, int d) {
        if (expenditure.length < d)
            return 0;

        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        int notifications = 0;

        for (int current = 0; current < expenditure.length; current++) {
            if (current >= d) {
                double median;
                if (lower.size() > higher.size()){
                    median = lower.peek();
                } else {
                    median = (lower.peek()+ higher.peek()) / 2.0;
                }

                if (expenditure[current] >= median * 2)
                    notifications++;

                if (expenditure[current - d] < median) {
                    lower.remove(expenditure[current - d]);
                    lower.offer(higher.poll());
                } else {
                    higher.remove(expenditure[current - d]);
                    higher.offer(lower.poll());
                }
            }
            higher.offer(expenditure[current]);
            lower.offer(higher.poll());
            if (higher.size() < lower.size())
                higher.offer(lower.poll());
        }
        return notifications;
    }

}
