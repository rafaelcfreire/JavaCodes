package sedgewick.chp2;

public final class QuickBaseSort extends IntegerSortAlgorithm {
    static int counter = 0;

    @Override
    public void sort(final Integer[] a) {
        sort(a, 0, a.length - 1);
    }

    private int partition(Integer[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Integer v = a[lo];

        while(true){
         while(less(a[++i], v))
             if(i == hi)
                 break;
         while(less(v, a[--j]))
             if(j == lo)
                 break;
         if(i >= j)
             break;
         exchange(a, i, j);
         counter += 1;
        }
        exchange(a, lo, j);
        counter += 1;
        return j;
    }

    private void exchange(Integer[] a, int i, int j){
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void sort(Integer[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
}