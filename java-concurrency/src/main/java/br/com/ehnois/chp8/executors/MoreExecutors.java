package br.com.ehnois.chp8.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

final class MoreExecutors {

    static ExecutorService newFixedThreadPool(int nThreads) {
        return new LocalThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    static ExecutorService newSingleThreadPool() {
        return new LocalThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = MoreExecutors.newSingleThreadPool();
        List<Future<String>> futures = new ArrayList<>();

        futures.add(exec.submit(() -> {
            Thread.sleep(10000);
            return "Delayed runnable";
        }));
        futures.add(exec.submit(() -> "no delayed"));
        exec.shutdown();

        for (Future<String> curr : futures) {
            System.out.println(curr.get());
        }
    }
}

class LocalThreadPoolExecutor extends ThreadPoolExecutor {

    public LocalThreadPoolExecutor(final int corePoolSize,
                                   final int maximumPoolSize,
                                   final long keepAliveTime,
                                   final TimeUnit unit,
                                   final BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public LocalThreadPoolExecutor(final int corePoolSize,
                                   final int maximumPoolSize,
                                   final long keepAliveTime,
                                   final TimeUnit unit,
                                   final BlockingQueue<Runnable> workQueue,
                                   final ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public LocalThreadPoolExecutor(final int corePoolSize,
                                   final int maximumPoolSize,
                                   final long keepAliveTime,
                                   final TimeUnit unit,
                                   final BlockingQueue<Runnable> workQueue,
                                   final RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public LocalThreadPoolExecutor(final int corePoolSize,
                                   final int maximumPoolSize,
                                   final long keepAliveTime,
                                   final TimeUnit unit,
                                   final BlockingQueue<Runnable> workQueue,
                                   final ThreadFactory threadFactory,
                                   final RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(final Thread t, final Runnable r) {
        System.out.println("Calling before execute");
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(final Runnable r, final Throwable t) {
        System.out.println("Calling after execute");
        super.afterExecute(r, t);
    }

    @Override
    protected void terminated() {
        System.out.println("Executor is been terminated");
        super.terminated();
    }
}