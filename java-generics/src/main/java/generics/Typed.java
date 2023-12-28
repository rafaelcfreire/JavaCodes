package generics;

import java.time.LocalDate;
import java.util.*;

public class Typed {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add("Hello");
        objects.add(LocalDate.now());
        objects.add(3);

        System.out.println(objects);

    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
}
