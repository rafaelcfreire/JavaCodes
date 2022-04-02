package algoexpert.stack;

import java.util.ArrayList;
import java.util.List;

public class SortStack {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.addAll(List.of(-5, 2, -2, 4, 3, 1));
        List<Integer> result = sortStack(list);
    }

    public static List<Integer> sortStack(List<Integer> stack) {
        if (stack.size() == 0)
            return stack;

        int top = stack.remove(stack.size() - 1);
        sortStack(stack);
        insertInSortOrder(top, stack);

        return stack;
    }

    private static void insertInSortOrder(int value, List<Integer> stack) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }

        int top = stack.remove(stack.size() - 1);
        insertInSortOrder(value, stack);
        stack.add(top);
    }
}
