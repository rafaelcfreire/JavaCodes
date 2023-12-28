package br.com.ehnois.chp4.pc;

final class Consumer extends Thread {

    private final SharedArray sharedArray;

    public Consumer(SharedArray sharedArray) {
        this.sharedArray = sharedArray;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        sharedArray.consumeLast();
    }
}
