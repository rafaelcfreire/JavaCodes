package item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Principal {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("what", "ball", "hack", "year");

//        Collections.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        words.forEach(System.out::println);

        Collections.sort(words, (s1, s2) -> s1.compareTo(s2));

        System.out.println(doOperation(((x, y) -> x * y), 5, 3));
    }

    public static Integer doOperation(Operate<Integer> operate, int a, int b) {
        return operate.operate(a, b);
    }
}
