package algoexpert.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LaptopRentals {
    public static void main(String[] args) {
        List<List<Integer>> items = new ArrayList<>();
        items.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        items.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        items.add(new ArrayList<Integer>(Arrays.asList(4, 6)));
        items.add(new ArrayList<Integer>(Arrays.asList(0, 4)));
        items.add(new ArrayList<Integer>(Arrays.asList(7, 8)));
        items.add(new ArrayList<Integer>(Arrays.asList(9, 11)));
        items.add(new ArrayList<Integer>(Arrays.asList(3, 10)));
        laptopRentals(items);
    }

    public static int laptopRentals(List<List<Integer>> times) {
        int[] startTime = new int[times.size()];
        int[] endTime = new int[times.size()];
        int laptops = 0;
        for (int i = 0; i < times.size(); i++) {
            startTime[i] = times.get(i).get(0);
            endTime[i] = times.get(i).get(1);
        }

        //Sort ascending both start and end times
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i = 0, j = 0;
        while (i < startTime.length) {
            if (startTime[i] >= endTime[j]) {
                laptops -= 1;
                j++;
            }
            laptops += 1;
            i++;
        }
        return laptops;
    }

}
