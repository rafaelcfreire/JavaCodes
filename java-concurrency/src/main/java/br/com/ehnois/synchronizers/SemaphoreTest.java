package br.com.ehnois.synchronizers;

import java.util.concurrent.Semaphore;

final class SemaphoreTest {
    private final Semaphore nonFairSemaphore = new Semaphore(100);

    private final Semaphore fairSemaphore = new Semaphore(100, true);


}
