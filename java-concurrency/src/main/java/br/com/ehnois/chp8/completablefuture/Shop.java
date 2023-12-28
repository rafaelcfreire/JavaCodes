package br.com.ehnois.chp8.completablefuture;

import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

final class Shop {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        long startTime = System.currentTimeMillis();
//        double result = getPrice("TV 75");
//        long endTime = System.currentTimeMillis() - startTime;
//        System.out.println("Sync Invocation took: "+endTime);
//        System.out.println(result);

        long startTimeAsync = System.currentTimeMillis();
        Future<Double> futurePrice = getPriceAsync("TV 85");
        long endTimeAsync = System.currentTimeMillis() - startTimeAsync;
        System.out.println("Async Invocation took: "+endTimeAsync);
        //AS the async invocation returns immediately, the main thread can be used to do something else
        //doSomethingElse()
        double price = futurePrice.get();
        System.out.println(price);
        System.out.println("Done");
    }

    public static Future<Double> getPriceAsync(String product) {
        return supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                futurePrice.complete(price);
//            } catch (Exception ex) {
//                futurePrice.completeExceptionally(ex);
//            }
//        }).start();
//        return futurePrice;
    }

    public static double getPrice(String product) {
        return calculatePrice(product);
    }

    private static void delay() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static double calculatePrice(String product) {
        delay();
        Random random = new Random();
        throw new RuntimeException("Failure on calculation");
//
//        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}


