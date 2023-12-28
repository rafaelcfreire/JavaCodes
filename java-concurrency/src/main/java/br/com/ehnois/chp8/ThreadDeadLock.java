package br.com.ehnois.chp8;

import java.util.concurrent.*;

import static br.com.ehnois.chp8.ThreadDeadLock.exec;

final class ThreadDeadLock {

    static ExecutorService exec = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InnerThreadDeadLock itd = new InnerThreadDeadLock();

        exec.submit(itd::call);
        System.out.println("I am finished");
    }
}

class InnerThreadDeadLock implements Callable<String>{

    public String call() throws ExecutionException, InterruptedException {
        Future<String> header, footer;
        Callable<String> headerCallable = () -> "header calling";
        Callable<String> footerCallable = () -> "footer calling";

        header = exec.submit(headerCallable);
        footer = exec.submit(footerCallable);

        String response = header.get() + footer.get();

        System.out.println("After response");
        return response;
    }
}