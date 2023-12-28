package br.com.ehnois.chp5.synchronizers.collections;

import java.util.Vector;

final class VectorExample {
    Vector<Integer> vector = new Vector<>();

    VectorExample() {
        for(int i = 1; i <= 10; i++)
            vector.add(i);
    }

    public static void main(String[] args) {
        VectorExample vectorExample = new VectorExample();
        ReaderThread readerThread = new ReaderThread(vectorExample);
        SwapperThread swapperThread = new SwapperThread(vectorExample);

        readerThread.start();
        swapperThread.start();
    }
}
