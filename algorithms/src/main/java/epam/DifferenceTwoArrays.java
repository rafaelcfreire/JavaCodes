package epam;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class DifferenceTwoArrays {
    public static void main(String[] args) {
        int[] result = differenceTwoArrays(new int[]{1, 2, 2, 2, 3, 1}, new int[]{2});
        for(int value : result) {
            System.out.print(" "+value);
        }
    }

    public static int[] differenceTwoArrays(int[] a, int[] b) {
        Set<Integer> collection = Arrays.stream(a).boxed().collect(Collectors.toSet());
            for(int current : b) {
                if(collection.contains(current))
                    collection.remove(current);
            }
            return collection.stream().mapToInt(i -> i).toArray();

        //        Arrays.sort(b);
//        int[] temp = new int[0];
//        for(int i = 0; i < a.length; i++) {
//            if(binarySearch(b, a[i]) == -1) {
//                temp = addElement(temp, a[i]);
//            }
//        }
//        return temp;
    }

    private static int[] addElement(int[] a, int element) {
        int[] temp = new int[a.length + 1];
        for(int i = 0; i < a.length; i++)
            temp[i] = a[i];
        temp[a.length] = element;
        return temp;
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (target < array[middle])
                high = middle - 1;
            else if(target > array[middle])
                low = middle + 1;
            else return target;
        }
        return -1;
    }

}
