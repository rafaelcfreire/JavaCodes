package br.com.ehnois.chp6.executor;

import java.util.concurrent.*;

import static java.lang.Thread.*;

final class FutureRenderer {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    void renderPage()  {
        Future<String> component = retrieveComponent();
        try {
            System.out.println(String.format("Rendered page %s - Main On thread: %s", component.get(), Thread.currentThread().getName()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }

    private Future<String> retrieveComponent() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return executor.submit(() -> String.format("Result from Future on thread %s", Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        FutureRenderer renderer = new FutureRenderer();
        renderer.renderPage();
    }
}
