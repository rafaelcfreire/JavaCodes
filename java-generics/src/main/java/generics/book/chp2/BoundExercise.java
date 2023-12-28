package generics.book.chp2;

import java.util.*;

final class BoundExercise {

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0, 1, 2);
        System.out.println(max(ints));

        List<String> strs = Arrays.asList("zero", "one", "two");
        System.out.println(max(strs));

        List<Number> nums = Arrays.asList(0, 1, 2, 3.14);
//        System.out.println(max(nums));
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
        Iterator<? extends T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

}
