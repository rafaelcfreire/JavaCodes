package algoexpert.arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        arrayOfProducts2(new int[]{5, 1, 4, 2});
    }

    public static int[] arrayOfProducts1(int[] array) {
        int[] product = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int result = 1;

            for (int j = 0; j < array.length; j++) {
                if (j != i)
                    result = result * array[j];
            }
            product[i] = result;
        }
        return product;
    }

    public static int[] arrayOfProducts2(int[] array) {
        int[] product = new int[array.length];
        int[] leftSide = new int[array.length];
        int[] rightSide = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftSide[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightSide[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for (int i = 0; i < array.length; i++)
            product[i] = leftSide[i] * rightSide[i];
        return product;
    }
}
