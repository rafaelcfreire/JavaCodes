package hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class EqualStacks {
    public static void main(String[] args) throws Exception {
        File f = new File("files/equalStackTestCase5");
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

        //System.out.println(equalStacks(List.of(3, 2, 1, 1, 1), List.of(4, 3, 2), List.of(1, 1, 4, 1)));
        //System.out.println(equalStacks(List.of(3, 7), List.of(1, 3, 1), List.of(1, 1, 1, 1, 2)));
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int minHeightValue = Math.min(Math.min(h1.stream().collect(Collectors.summingInt(Integer::intValue)),
                h2.stream().collect(Collectors.summingInt(Integer::intValue))),
                h3.stream().collect(Collectors.summingInt(Integer::intValue)));

        List<Integer> minList = new ArrayList<>();
        List<Integer> secondMin = new ArrayList<>();
        List<Integer> thirdMin = new ArrayList<>();

        if(h1.stream().collect(Collectors.summingInt(Integer::intValue)) != minHeightValue) {
            secondMin = h1;
        } else {
            minList = h1;
        }
        if(h2.stream().collect(Collectors.summingInt(Integer::intValue)) != minHeightValue) {
            if(h2.stream().collect(Collectors.summingInt(Integer::intValue)) <
                    secondMin.stream().collect(Collectors.summingInt(Integer::intValue)) || secondMin.size() == 0){
                thirdMin = secondMin;
                secondMin = h2;
            } else {
                thirdMin = h2;
            }
        } else {
            minList = h2;
        }
        if(h3.stream().collect(Collectors.summingInt(Integer::intValue)) != minHeightValue) {
            if(h3.stream().collect(Collectors.summingInt(Integer::intValue)) <
                    secondMin.stream().collect(Collectors.summingInt(Integer::intValue))){
                thirdMin = secondMin;
                secondMin = h3;
            } else {
                thirdMin = h3;
            }
        } else {
            minList = h3;
        }

        int returnValue = 0;
        for(int counter = 0; counter <= minList.size(); counter++) {
            int currentMinimum = minList.stream().skip(counter).collect(Collectors.summingInt(Integer::intValue));
            if(findItemInList(secondMin, currentMinimum, 0, secondMin.size() / 2) != 0 &&
                    findItemInList(thirdMin, currentMinimum, 0, secondMin.size() / 2) != 0) {

                returnValue = currentMinimum;
                break;
            }
        }
        return returnValue;
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
