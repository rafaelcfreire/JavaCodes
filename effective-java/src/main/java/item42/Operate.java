package item42;

@FunctionalInterface
public interface Operate<T> {
    T operate(T x, T y);
}
