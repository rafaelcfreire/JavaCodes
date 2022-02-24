package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionArrays {
    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 2, 2, 1};
        int[] arrayB = new int[]{2, 2};

        int[] results = intersection(arrayA, arrayB);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        nums1 = sort(nums1);
        nums2 = sort(nums2);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            nums2 = binarySearch(nums2, nums1[i], result);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] binarySearch(int[] array, int target, List<Integer> results) {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] < target) {
                low = middle + 1;
            } else if (array[middle] > target) {
                high = middle - 1;
            } else {
                results.add(array[middle]);
                array = removeElement(array, middle);
                break;
            }
        }
        return array;
    }

    private static int[] sort(int[] array) {
        return IntStream.of(array).sorted().toArray();
    }

    private static int[] removeElement(int[] array, int index) {
        return IntStream.range(0, array.length)
                .filter(i -> i != index)
                .map(i -> array[i])
                .toArray();
    }
}
