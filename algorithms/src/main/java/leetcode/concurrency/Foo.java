package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

class Foo {
    private Semaphore secondAllowed = new Semaphore(0);
    private Semaphore thirdAllowed = new Semaphore(0);
    public void first() {
        System.out.println("first");
        secondAllowed.release();
    }

    public void second() {
        try {
            secondAllowed.acquire(1);
        } catch (InterruptedException e) {
            System.out.println("failed to acquire lock");
        }
        System.out.println("second");
        thirdAllowed.release();
    }

    public void third() {
        try {
            thirdAllowed.acquire(1);
        } catch (InterruptedException e) {
            System.out.println("failed to acquire lock");
        }
        System.out.println("third");
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread tA = new Thread(foo::first);
        Thread tB = new Thread(foo::second);
        Thread tC = new Thread(foo::third);
        tA.start();
        tC.start();
        tB.start();
    }
}