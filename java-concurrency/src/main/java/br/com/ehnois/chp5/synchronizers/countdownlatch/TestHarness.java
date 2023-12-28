package br.com.ehnois.chp5.synchronizers.countdownlatch;

import java.util.concurrent.CountDownLatch;

final class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    System.out.println(String.format("%s is waiting", Thread.currentThread().getName()));
                    startGate.await();
                    try {
                        System.out.println(String.format("%s is starting to execute", Thread.currentThread().getName()));
                        task.run();
                    } finally {
                        System.out.println(String.format("%s is counting down", Thread.currentThread().getName()));
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) { }
            });
            t.start();
        }

        long start = System.nanoTime();
        Thread.sleep(5000);
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness th = new TestHarness();
        th.timeTasks(4, () ->
            System.out.println("Hello from the task")
        );
    }
}
