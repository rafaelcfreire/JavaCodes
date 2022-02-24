package algoexpert.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
//        values.add(4);
        powerset(values);
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(List.of());

        for (int current : array) {
            int setSize = sets.size();

            for (int i = 0; i < setSize; i++) {
                List<Integer> newList = new ArrayList<>(sets.get(i));
                newList.add(current);
                sets.add(newList);
            }
        }
        return sets;
    }
}




//            sets.add(List.of(array.get(i)));
//                    List<Integer> temp = new ArrayList<>();
//        temp.add(array.get(i));
//
//        for (int j = i + 1; j < array.size(); j++) {
//        if (i != array.size() - 2 && j != array.size() - 1)
//        sets.add(List.of(array.get(i), array.get(j)));
//        temp.add(array.get(j));
//        }
//        sets.add(temp);
