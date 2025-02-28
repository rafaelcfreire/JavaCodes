package br.com.ehnois.chp7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

final class PrimeGenerator implements Runnable{
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean canceled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!canceled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        this.canceled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        System.out.println(generator.get());
    }
}
