package book.chp2;

public final class BottomUpMergeBaseSort extends IntegerSortAlgorithm {
    private Integer[] aux;
    private int counter = 0;

    @Override
    public void sort(final Integer[] a) {
        int n = a.length;
        aux = new Integer[n];

        for(int len = 1; len < n; len *= 2)
            for(int lo = 0; lo < n - len; lo += len+len)
                merge(a, lo, lo+len - 1, Math.min(lo+len+len-1, n - 1));
    }

    private void merge(Integer[] a, int lo, int middle, int hi) {
        int i = lo, j = middle + 1;

        for (int k = 0; k < a.length; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++){
            if(i > middle) {
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i])) {
                counter += 1;
                a[k] = aux[j++];
            }
            else
                a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        BottomUpMergeBaseSort bottomUpMergeSort = new BottomUpMergeBaseSort();
        bottomUpMergeSort.triggerSort();
    }
}