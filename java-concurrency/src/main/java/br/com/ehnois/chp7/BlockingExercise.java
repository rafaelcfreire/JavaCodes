package br.com.ehnois.chp7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class BlockingExercise {
    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        BlockingExercise be = new BlockingExercise();
        be.blockingQueue.take();
        System.out.println("After blocked");
    }
}
