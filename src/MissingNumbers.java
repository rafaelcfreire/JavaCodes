import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbers {
    public static void main(String[] args) {
        //int[] a = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        //int[] b = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};

        int[] a = {11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        int[] b = {11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};

        int[] result = missingNumbers(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Long> mapB = Arrays.stream(brr).boxed()
                .collect(Collectors.groupingBy(integer -> integer, TreeMap::new, Collectors.counting()));

        Arrays.stream(arr).boxed().forEach(integer -> {
            if(mapB.containsKey(integer)){
                mapB.put(integer, mapB.get(integer) - 1);
            }
        });

        List<Integer> finalValue = new ArrayList<>();
        mapB.forEach((integer, aLong) -> {
            if(aLong > 0)
                finalValue.add(integer);
        });
        return finalValue.stream().mapToInt(i->i).toArray();
    }
}
