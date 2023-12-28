package br.com.ehnois.chp5.synchronizers.collections;

final class SwapperThread extends Thread{
    private VectorExample vectorExample;

    SwapperThread(VectorExample vectorExample) {
        this.vectorExample = vectorExample;
    }

    @Override
    public void run() {
        System.out.println("Reading vector on SwapperThread");
        int lastIndex = vectorExample.vector.size() - 1;
        System.out.println(String.format("Index removed: %d", lastIndex));
        vectorExample.vector.remove(lastIndex);
    }
}
