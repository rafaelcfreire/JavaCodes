package algoexpert.searching;

public class ThreeLargest {
    public static void main(String[] args) {
//        findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        findThreeLargestNumbers(new int[]{-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7});
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;

        for(int k = 0; k < array.length; k++) {
            if(array[k] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = array[k];
            } else if(array[k] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = array[k];
            } else if(array[k] > thirdLargest) {
                thirdLargest = array[k];
            }
        }
        return new int[]{thirdLargest, secondLargest, largest};
    }
}
