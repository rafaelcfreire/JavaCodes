package hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class BalancedSums {
    public static void main(String[] args) {
        //balancedSums(List.of(1,2,3,4,5,6,7,8,28));
        //balancedSums(List.of(5,6,8,11));
        //balancedSums(List.of(44,1,2,3,4,5,6,7,8,9));
        System.out.println(balancedSums(List.of(10, 54, 29, 74, 95, 16, 26, 83, 64, 52, 15, 40, 35, 80, 62, 74, 45, 12,
                45, 7, 54, 21, 20, 11, 7, 3, 13, 52, 63, 51, 91, 25, 74, 42, 43, 81, 42, 19, 30, 29, 53, 57, 3, 1, 40,
                43, 38, 71, 73, 6, 89, 78, 31, 78, 19, 52, 56, 49, 47, 61, 34, 51, 18, 30, 91, 93, 23, 3, 63, 46, 72,
                6, 54, 61, 31, 89, 51, 28, 63, 12, 99, 78, 19, 36, 72, 71, 95, 49, 54, 67, 15, 89, 25, 19, 41, 83, 69, 19, 15, 81)));
    }

    static String balancedSums(List<Integer> arr) {
        if(arr.stream().skip(1).collect(Collectors.summingInt(Integer::intValue)) == 0)
            return "YES";

        return findItemInList(arr, 0, arr.size()) != 0 ? "YES" : "NO";
    }

    private static int findItemInList(List<Integer> range, int minMedian, int maxMedian) {
        int median = (maxMedian + minMedian) / 2;
        int foundValueLower = range.stream().limit(median).collect(Collectors.summingInt(Integer::intValue));
        int foundValueHigher = range.stream().skip(median + 1).collect(Collectors.summingInt(Integer::intValue));
        int temp = 0;

        if((median == minMedian || median == maxMedian) && foundValueHigher != foundValueLower){
            return 0;
        }
        if(foundValueHigher == foundValueLower) {
            return median;
        } else if( foundValueLower < foundValueHigher) {
            temp = findItemInList(range, median, maxMedian);
        } else if( foundValueLower > foundValueHigher) {
            temp = findItemInList(range, minMedian, median);
        }
        return temp;
    }

}
