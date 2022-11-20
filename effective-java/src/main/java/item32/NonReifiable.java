package item32;

import java.util.List;

public class NonReifiable {
    public static void main(String[] args) {
        dangerous(List.of("this", "is"), List.of("a", "test"));
    }

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);

        Object[] objects = stringLists;

        objects[0] = intList;

        String s = stringLists[0].get(0);
    }
}
