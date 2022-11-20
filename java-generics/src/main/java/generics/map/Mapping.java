package generics.map;

import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface Mapping<T> {
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
}
