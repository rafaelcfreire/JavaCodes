package br.com.ehnois.chp3;

import java.util.Optional;
import java.util.function.BiConsumer;

final class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<>();

    private static BiConsumer<String, Integer> consumer = (threadName, value) -> {
        threadId.set(Optional.ofNullable(threadId.get()).orElse(0) + value);
        System.out.println(String.format("%s Thread: %s, %d", threadName, Thread.currentThread().getName(), threadId.get()));
    };

    public static void main(String[] args) {
        new Thread(() -> {
            consumer.accept("First", 5);
        }).start();
        new Thread(() -> {
            consumer.accept("Second", 10);
        }).start();
        consumer.accept("Main", 50);
    }
}
