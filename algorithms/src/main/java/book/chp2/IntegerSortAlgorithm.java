package book.chp2;

import book.common.StdRandom;

abstract class IntegerSortAlgorithm extends BaseSortAlgorithm<Integer> {

    @Override
    Integer[] getRandomNumbers() {
        int MAX = 1000;
        int N = 1000;

        Integer[] a =new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, MAX);
        return a;
    }

    @Override
    boolean less(Integer v,Integer w){
        return v.compareTo(w) < 0;
    }
}