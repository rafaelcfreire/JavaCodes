package br.com.ehnois.chp7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

final class BrokenPrimeGenerator extends Thread {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean canceled = false;

    private BrokenPrimeGenerator(final BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!canceled) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
        }
    }


}
