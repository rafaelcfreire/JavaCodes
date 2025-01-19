package mjic.chp7;

import java.util.concurrent.RecursiveTask;

final class ForkedFibonacci extends RecursiveTask<Integer> {
    final int n;

    ForkedFibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1)
            return n;
        ForkedFibonacci f1 = new ForkedFibonacci(n - 1);
        f1.fork();
        ForkedFibonacci f2 = new ForkedFibonacci(n - 2);
        return f2.compute() + f1.join();
    }

    public static void main(String[] args) {
        ForkedFibonacci forkedFibonacci = new ForkedFibonacci(45);

        long startTime = System.nanoTime();
        System.out.println(forkedFibonacci.compute());
        long finish = System.nanoTime() - startTime;
        System.out.println("finish time: "+finish);
    }
}