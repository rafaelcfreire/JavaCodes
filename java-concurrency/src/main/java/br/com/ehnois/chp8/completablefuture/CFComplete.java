package br.com.ehnois.chp8.completablefuture;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

// Taken from Modern Java in Action - chp 15.4
final class CFComplete {

    static int doubleValue(int value) {
        System.out.println("Starting double value with Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing double value");
        return value * 2;
    }

    static int tripleValue(int value) {
        System.out.println("Starting triple with Thread: "+Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing triple value");
        return value * 3;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Stopwatch timer = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        executorService.submit(() -> a.complete(doubleValue(x)));

        CompletableFuture<Integer> b = new CompletableFuture<>();
        executorService.submit(() -> b.complete(tripleValue(x)));

        System.out.println(a.get() + b.get());
        executorService.shutdown();

        System.out.println("Time took in seconds: "+timer.elapsed(SECONDS));
    }
}
