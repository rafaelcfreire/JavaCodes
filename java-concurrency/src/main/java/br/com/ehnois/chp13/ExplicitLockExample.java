package br.com.ehnois.chp13;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class ExplicitLockExample {
    private int counter = 0;

    Lock lock = new ReentrantLock();

    public int getCounter() {
        int c;
        try {
            lock.lockInterruptibly();
            c = counter;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return c;
    }

    public void setCounter(final int counter) {
        try {
            lock.lock();
            Thread.sleep(10000);
            this.counter = counter;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        ExplicitLockExample explicitLockExample = new ExplicitLockExample();
        executor.execute(() -> explicitLockExample.setCounter(10));
        Future<Integer> counter = executor.submit(() -> explicitLockExample.getCounter());
        System.out.println(counter.get());
        executor.shutdown();
    }
}

