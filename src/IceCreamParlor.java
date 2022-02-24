import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IceCreamParlor {
    public static void main(String[] args) {
        icecreamParlor(4, new int[]{1, 4, 5, 3, 2, 2});
    }

    static void icecreamParlor(int m, int[] arr) {
        Map<Integer, List<Integer>> valueMap = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.groupingBy(i -> arr[i], Collectors.mapping(integer -> integer, Collectors.toList())));

        System.out.println(valueMap);

    }
}
