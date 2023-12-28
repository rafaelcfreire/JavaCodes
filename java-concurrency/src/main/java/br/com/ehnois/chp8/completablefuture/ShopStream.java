package br.com.ehnois.chp8.completablefuture;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

final class ShopStream {
    List<Store> stores = List.of(new Store("temp1"), new Store("temp2"), new Store("temp3"), new Store("temp4"), new Store("temp5"));

    public static void main(String[] args) {
        ShopStream ss = new ShopStream();
        long startTime = System.currentTimeMillis();
        ss.findPricesWithCompletableFutureSingleStream("Apple iPhone");
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Sync Invocation took: "+endTime);
    }

    public List<String> findPrices(String product) {
        return stores.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallel(String product) {
        return stores.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletableFutureSingleStream(String product) {
        return stores.stream()
                .map(shop -> supplyAsync(() -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product))))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletable(String product) {
        List<CompletableFuture<String>> priceFutures = stores.stream()
                .map(shop -> supplyAsync(() -> String.format("%s price is %.2f",
                        shop.getName(), shop.getPrice(product)))).toList();

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}

class Store {
    private String name;

    String getName() {
        return name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private void delay() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    Store(final String name) {
        this.name = name;
    }
}