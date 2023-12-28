package br.com.ehnois.chp4.pc;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class Producer extends Thread {

    private final SharedArray sharedArray;

    public Producer(SharedArray sharedArray) {
        this.sharedArray = sharedArray;
    }

    @Override
    public void run() {
        Random rand = new Random();
        sharedArray.addElement(rand.nextInt(10000));
    }

    public static void main(String[] args) {
        SharedArray sa = new SharedArray();
        Producer producer = new Producer(sa);
        Consumer consumer = new Consumer(sa);
        Executor executorProducer = Executors.newSingleThreadExecutor();
        Executor executorConsumer = Executors.newSingleThreadExecutor();

        while (true) {
            executorProducer.execute(producer);
            executorConsumer.execute(consumer);
        }
    }
}
