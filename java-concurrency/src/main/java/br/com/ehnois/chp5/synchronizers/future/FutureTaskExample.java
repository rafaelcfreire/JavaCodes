package br.com.ehnois.chp5.synchronizers.future;

import java.util.Random;
import java.util.concurrent.*;

final class FutureTaskExample {

    private final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Future<Integer> getContent() {
        return executor.submit(() -> {
            Thread.sleep(5000);
            return new Random().nextInt();
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting main Thread");
        int result = new FutureTaskExample().getContent().get();
        System.out.println(String.format("Executing with result %s", result));
    }
}
