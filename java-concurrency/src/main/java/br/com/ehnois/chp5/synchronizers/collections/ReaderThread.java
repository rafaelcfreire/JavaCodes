package br.com.ehnois.chp5.synchronizers.collections;

final class ReaderThread extends Thread{

    private VectorExample vectorExample;

    ReaderThread(VectorExample vectorExample) {
        this.vectorExample = vectorExample;
    }

    @Override
    public void run() {
        System.out.println("Reading vector on ReaderThread");
        int lastIndex = vectorExample.vector.size() - 1;
        Thread.yield();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(String.format("Vector last index %d", lastIndex));
    }
}
