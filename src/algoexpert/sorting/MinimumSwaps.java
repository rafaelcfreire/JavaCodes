package algoexpert.sorting;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumSwaps {
    public static void main(String[] args) {
        minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});
    }

    static int minimumSwaps(int[] arr) {
        int minimumSwaps = 0;
        int[] orderedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(orderedArray);

        Map<Integer, Integer> position = IntStream.range(0, orderedArray.length).boxed()
                .collect(Collectors.toMap(i -> orderedArray[i], Function.identity()));

        for(int y = 0; y < arr.length; y++) {
            if(arr[y] != orderedArray[y]){
                exchange(arr, position.get(arr[y]), y);
                y = 0;
                minimumSwaps++;
            }
        }
        return minimumSwaps;
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
