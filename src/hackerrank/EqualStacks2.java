package hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualStacks2 {
    public static void main(String[] args) throws Exception {
        File f = new File("files/equalStackTestCase6");
        BufferedReader b = new BufferedReader(new FileReader(f));
        String temp1 = b.readLine();
        String temp2 = b.readLine();
        String temp3 = b.readLine();

        Instant start = Instant.now();

        System.out.println(
                equalStacks(
                        Arrays.stream(temp1.split(" ")).map(Integer::valueOf).collect(Collectors.toList()),
                        Arrays.stream(temp2.split(" ")).map(Integer::valueOf).collect(Collectors.toList()),
                        Arrays.stream(temp3.split(" ")).map(Integer::valueOf).collect(Collectors.toList())
                )
        );
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int minValue = Math.min(Math.min(h1.stream().collect(Collectors.summingInt(Integer::intValue)),
                h2.stream().collect(Collectors.summingInt(Integer::intValue))),
                h3.stream().collect(Collectors.summingInt(Integer::intValue)));

        List<Integer> minList = new ArrayList<>();
        List<List<Integer>> indexes = new ArrayList<>();
        if(h1.stream().collect(Collectors.summingInt(Integer::intValue)) != minValue) {
            indexes.add(h1);
        } else {
            minList = h1;
        }
        if(h2.stream().collect(Collectors.summingInt(Integer::intValue)) != minValue) {
            indexes.add(h2);
        } else {
            minList = h2;
        }
        if(h3.stream().collect(Collectors.summingInt(Integer::intValue)) != minValue) {
            indexes.add(h3);
        } else {
            minList = h3;
        }

        int currentIndex = 1;
        while(!checkIfStacksMatch(minValue, indexes) && minValue != 0) {
            minValue = minList.stream().skip(currentIndex).collect(Collectors.summingInt(Integer::intValue));
            currentIndex++;
        }
        return minValue;
    }

    private static boolean checkIfStacksMatch(int minValue, List<List<Integer>> indexes) {
        boolean bothIndexesPass = false;

        for(List<Integer> entry : indexes) {

            int upperBound = findItemInList(entry, minValue, 0, entry.size() / 2);
            if(upperBound != 0) {
                bothIndexesPass = true;
            } else {
                bothIndexesPass = false;
                break;
            }
        }
        return bothIndexesPass;
    }

    private static int findItemInList(List<Integer> range, int valueToFind, int lowerBound, int upperBound) {
        int foundValue = range.stream().skip(upperBound).collect(Collectors.summingInt(Integer::intValue));
        int temp = 0;

        if(upperBound == lowerBound) {
            return 0;
        }
        if(foundValue == valueToFind) {
            return upperBound;
        } else if(foundValue > valueToFind) {
            temp = findItemInList(range, valueToFind,     upperBound,(upperBound + range.size()) / 2);
        } else if(foundValue < valueToFind) {
            temp = findItemInList(range, valueToFind, lowerBound, (lowerBound + upperBound) / 2 );
        }
        return temp;
    }

}
