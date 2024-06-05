package book.chp2;

final class BubbleBaseSort extends IntegerSortAlgorithm {
    @Override
    public void sort(final Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleBaseSort bubbleSort = new BubbleBaseSort();
        bubbleSort.triggerSort();
    }
}
