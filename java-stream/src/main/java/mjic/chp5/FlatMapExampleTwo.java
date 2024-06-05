package mjic.chp5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/*
 * Given two lists of numbers, how would you return all pairs of numbers?
 * For example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
 * For simplicity, you can represent a pair as an array with two elements.
 */
final class FlatMapExampleTwo {
    public static void main(String[] args) {
        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 4);

        List<Integer[]> collection = listOne.stream()
                .flatMap(elementOne ->
                        listTwo.stream().map(elementTwo -> new Integer[]{elementOne, elementTwo}))
                .collect(toList());

        System.out.println(collection);
    }
}