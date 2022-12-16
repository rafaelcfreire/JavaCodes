package item43;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class MethodReferencesExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Teste", 5);
        map.put("Teste2", 10);
        map.merge("Teste", 3, (count, increment) -> count + increment);
        map.merge("Teste51", 3, (count, increment) -> count + increment);

        //Using method reference - STATIC
        map.merge("Teste2", 2, Integer::sum);

        System.out.println(map.get("Teste"));
        System.out.println(map.get("Teste51"));

        //Using method reference - INSTANCE METHOD
        List<String> strings = Arrays.asList("THis", "Is", "A", "List");
        strings.stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        strings.stream().sorted(String::compareTo).collect(Collectors.toList());

        //Using method reference - CONSTRUCTOR
        Stream.of(1,2,3,5,8,13).toArray(String[]::new);
    }

    private static void receiveIntArray(int[] array) {

    }
}
