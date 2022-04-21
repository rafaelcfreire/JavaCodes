package epam;

public class AscendingArray {
    public static void main(String[] args) {
        boolean isAscending = isAscending(new int[]{1, 2, 3, 4, 5});
    }

    public static boolean isAscending(int[] array) {
        return isAscending(array, array.length);
    }

    private static boolean isAscending(int[] array, int size) {
        if (size == 1)
            return true;
        if (array[size - 1] < array[size - 2])
            return false;
        else
            return isAscending(array, size - 1);
    }
}
