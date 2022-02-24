package algoexpert.arrays;

public class NonConstructableChange {
    public static void main(String[] args) {
//        System.out.println(nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
        System.out.println(nonConstructibleChange(new int[]{1, 1, 1, 1, 1}));
    }

    public static int nonConstructibleChange(int[] coins) {
        int totalAmount = 0;

        insertSort(coins);
        for(int value : coins) {
            if(value > totalAmount + 1)
                return totalAmount + 1;
            totalAmount += value;
        }
        return totalAmount + 1;
    }

    private static void insertSort(int[] array) {
        for(int k = 1; k < array.length; k++) {
            for(int j = k; j > 0 && array[j] < array[j - 1]; j--) {
                exchange(array, j, j - 1);
            }
        }
    }

    private static void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
