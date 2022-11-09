package generics.raw;

import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("raw");
        strings.add("list");
        strings.add("of");
        strings.add("strings");

        for(Object obj : strings) {
            String s = (String) obj;
            System.out.printf("%7s has %d characters%n", s, s.length());
        }
    }
}
