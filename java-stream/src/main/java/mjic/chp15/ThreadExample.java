package mjic.chp15;

import java.util.concurrent.TimeUnit;

final class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        long startTime = System.nanoTime();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result.left = 5;
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result.right = 3;
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(result.left + result.right);
        long finish = System.nanoTime() - startTime;
        System.out.println("finish time: "+ TimeUnit.SECONDS.convert(finish, TimeUnit.NANOSECONDS));
    }

    private static class Result {
        private int left;
        private int right;
    }
}