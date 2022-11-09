package generics.lowerbound;

import java.util.List;
import java.util.stream.Stream;

public class LowerBounds {
    public static void main(String[] args) {
        List<String> strings = Stream.of("a", "few", "strings").toList();

        strings.forEach((String s) -> System.out.printf("%s in all caps is %s%n", s, s.toUpperCase()));
        strings.forEach((Object o) -> System.out.printf("%s object hashcode is %d%n", o, o.hashCode()));
    }
}
