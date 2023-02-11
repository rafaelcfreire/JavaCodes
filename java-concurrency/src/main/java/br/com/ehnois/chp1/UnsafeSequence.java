package br.com.ehnois.chp1;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeSequence {
    private final AtomicInteger value = new AtomicInteger(0);

    public synchronized int getNext() {
        if (value.get() % 2 == 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    return value.incrementAndGet();
    }
}
