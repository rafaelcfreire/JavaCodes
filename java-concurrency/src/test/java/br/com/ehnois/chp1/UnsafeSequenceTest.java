package br.com.ehnois.chp1;


import org.junit.Test;

public class UnsafeSequenceTest {

    UnsafeSequence unsafeSequence = new UnsafeSequence();

    @Test
    public void testGetNextConcurrently() {
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> System.out.println(String.format("Thread: %s, counter: %d", Thread.currentThread().getName(),
                    unsafeSequence.getNext())));
            t.start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}