package item45;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class UseStreamJudiciously {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("staple", "petals", "yellow", "lowyel");

        words.stream().collect(groupingBy((word) -> alphabetize(word)))
                .values().stream().filter(group -> group.size() >= 1)
                .forEach(g -> System.out.println(g.size() + ":" +g));
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
