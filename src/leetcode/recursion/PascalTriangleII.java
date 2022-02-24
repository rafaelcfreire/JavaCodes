package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangleII {
    static Map<String, Integer> memoize = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getRow(30));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            results.add(calculateElementMemoize(rowIndex, i));
        }
        return results;
    }

    private static int calculateElement(int row, int column) {
        if (column == 0 || column == row)
            return 1;
        return calculateElement(row - 1, column - 1) + calculateElement(row - 1, column);
    }

    private static int calculateElementMemoize(int row, int column) {
        if (column == 0 || column == row)
            return 1;
        else if (memoize.containsKey(row+"-"+column)) {
            return memoize.get(row+"-"+column);
        } else {
            int result = calculateElementMemoize(row - 1, column - 1)
                    + calculateElementMemoize(row - 1, column);

            memoize.put(row+"-"+column, result);
            return result;
        }
    }
}
