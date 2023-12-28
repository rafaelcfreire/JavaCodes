package br.com.ehnois.chp5.synchronizers.countdownlatch;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly;

/**
 * Example taken from com.baml.gmt.xasf.common.util
 */
final class EvenMoreExecutors {
    private EvenMoreExecutors() {
    }

    public static boolean flushExecutor(Executor executor, Duration awaitDuration) {
        CountDownLatch runCompleted = new CountDownLatch(1);
        executor.execute(runCompleted::countDown);
        return awaitUninterruptibly(runCompleted, awaitDuration.toMillis(), TimeUnit.MILLISECONDS);
    }
}
