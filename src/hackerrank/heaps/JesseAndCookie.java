package hackerrank.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookie {

    public static void main(String[] args) {
//        List<Integer> temp = new ArrayList<>();
//        temp.add(2);
//        temp.add(7);
//        temp.add(3);
//        temp.add(6);
//        temp.add(4);
//        temp.add(6);
//        cookies(9, temp);

//        List<Integer> temp = new ArrayList<>();
//        temp.add(1);
//        temp.add(2);
//        temp.add(3);
//        temp.add(9);
//        temp.add(10);
//        temp.add(12);
//        System.out.println(cookies(7, temp));
        List<Integer> temp = Collections.nCopies(100000, 1);
        System.out.println(cookies(105823341, temp));
    }

    public static int cookies(int k, List<Integer> A) {
        int iterations = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);

        int lowest = pq.poll();
        while (lowest < k && !pq.isEmpty()) {
            iterations += 1;
            int secondLowest = pq.poll();
            int newValue = lowest + 2 * secondLowest;
            pq.add(newValue);
            if (pq.peek() > k)
                break;
            lowest = pq.poll();
        }
        return pq.isEmpty() && lowest != k ? -1 : iterations;
    }
}
