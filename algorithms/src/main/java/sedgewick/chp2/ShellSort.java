package sedgewick.chp2;

public final class ShellSort extends IntegerSortAlgorithm {

    private void exchange(Integer[] a, int i, int j) {
        Integer temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        shellSort.triggerSort();
    }

    @Override
    void sort(final Integer[] a) {
        int n = a.length;

        int h = 1;
        while(h < n/3)
            h = h*3 + 1;
        while(h >= 1) {
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h){
                    exchange(a, j, j - h);
                }
            }
            h = h/3;
        }
    }
}