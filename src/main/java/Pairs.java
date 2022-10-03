import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class Pairs {
    public static void main(String[] args) {
        Pairs.pairs(2, new int[]{1, 5, 3, 4, 2});
    }

    static int pairs(int k, int[] arr) {
        var totalAmountOfPairs = 0;

        Set<Integer> setOfDifferentElements = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for (int i = 0; i < arr.length; i++){
            if (setOfDifferentElements.contains(arr[i] + k)) {
                totalAmountOfPairs = totalAmountOfPairs + 1;
            }
        }
        return totalAmountOfPairs;
    }
}
