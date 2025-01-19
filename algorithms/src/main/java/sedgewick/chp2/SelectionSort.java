package sedgewick.chp2;

public final class SelectionSort extends IntegerSortAlgorithm {

    @Override
    void sort(final Integer[] a) {
        int n = a.length;

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    void exchange(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.triggerSort();
    }
}