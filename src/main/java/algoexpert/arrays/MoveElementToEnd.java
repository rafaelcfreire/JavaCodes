package algoexpert.arrays;

import java.util.ArrayList;
import java.util.List;

public final class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(2, 1, 2, 2, 2, 3, 4, 2));
        moveElementToEnd(list, 2);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftPointer = 0, rightPointer = array.size() - 1;

        while (leftPointer < rightPointer) {
            while (array.get(rightPointer) == toMove) {
                rightPointer--;
                if (rightPointer == 0) break;
            }
            if (rightPointer <= leftPointer) break;
            if (array.get(leftPointer) == toMove)
                exchange(array, leftPointer, rightPointer);
            leftPointer++;
        }
        return array;
    }

    private static void exchange(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
