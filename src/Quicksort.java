import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {
    public static void main(String[] args) {
        quicksort(new ArrayList<Integer>(Arrays.asList(86, 73, 19, 13, 31, 89, 6, 11, 69, 90, 97, 5, 65,
                59, 42, 30, 77, 40, 95, 61, 51, 76, 21, 48, 80, 78, 55, 25, 3, 81, 46, 14, 26, 41, 87, 15,
                75, 98, 20, 35, 12, 57, 53, 88, 60, 2, 68, 7, 29, 45)))
                .forEach(System.out::println);
    }

    private static List<Integer> quicksort(List<Integer> list) {

        if(list.size() < 2)
            return list;

        int pivot = list.get(list.size() / 2);

        List<Integer> lower = list.stream()
                .filter(integer -> integer != pivot)
                .filter(integer -> integer < pivot)
                .collect(Collectors.toList());

        List<Integer> greater = list.stream()
                .filter(integer -> integer != pivot)
                .filter(integer -> integer > pivot)
                .collect(Collectors.toList());

        return Stream.concat(Stream.concat(lower.stream(), Stream.of(pivot)), greater.stream())
                .collect(Collectors.toList());
    }
}
