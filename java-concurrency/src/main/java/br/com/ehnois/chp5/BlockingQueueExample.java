package br.com.ehnois.chp5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        new Thread(new Publisher(queue)).start();
        new Thread(new Publisher(queue)).start();

        new Thread(new Consumer(queue)).start();
    }

}

class Publisher implements Runnable {
    private final BlockingQueue<String> queue;

    Publisher(final BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (queue.offer(String.format("Add %s by %s", i, Thread.currentThread().getName())))
                System.out.println(String.format("After offering element %s to pool on Thread %s", i, Thread.currentThread().getName()));
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;

    Consumer(final BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String temp = queue.poll();
            System.out.println(String.format("Retrieved %s by Thread %s", temp, Thread.currentThread().getName()));
            try {
                Thread.sleep(50);
                System.out.println(String.format(" %s woke up", Thread.currentThread().getName()));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}