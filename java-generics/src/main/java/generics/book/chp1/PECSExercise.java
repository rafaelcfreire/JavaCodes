package generics.book.chp1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class PECSExercise {
    public static void main(String[] args) {
        List<Object> objs = Stream.of(2, 3.14).collect(Collectors.toList());
        List<Integer> ints = List.of(5, 6);

        copy(ints, objs);
        PECSExercise.<Object>copy(ints, objs);
        PECSExercise.<Number>copy(ints, objs);
        PECSExercise.<Integer>copy(ints, objs);
    }

    private static <T> void copy(List<? extends T> src, List<? super T> dst) {
        for (T element : src)
            dst.add(element);
    }
}
