package generics.upperbound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public void push(E e) {
        list.add(e);
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst) {
        while (!list.isEmpty())
            dst.add(list.remove(list.size() - 1));
    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        Iterable<Integer> src = Arrays.asList(Integer.valueOf(1), Integer.valueOf(2));
        stack.pushAll(src);

        Collection<Object> object = new ArrayList<>();
        stack.popAll(object);
    }
}
