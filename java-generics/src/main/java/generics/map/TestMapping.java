package generics.map;

import java.util.Arrays;
import java.util.List;

public class TestMapping {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aba", "ebe", "ibi", "obo", "ubu");
        list.stream().map(i -> i.hashCode()).forEach(System.out::println);
    }
}

