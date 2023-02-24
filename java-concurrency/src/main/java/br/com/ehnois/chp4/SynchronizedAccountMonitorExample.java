package br.com.ehnois.chp4;

import java.time.LocalDate;

/**
 * This class uses the Java monitor pattern
 */
final class SynchronizedAccountMonitorExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private long balance;
    private LocalDate accountAnniversary;

    private SynchronizedAccountMonitorExample(final long balance, final LocalDate accountAnniversary) {
        this.balance = balance;
        this.accountAnniversary = accountAnniversary;
    }

    public long getBalance() {
        synchronized (lock1) {
            return balance;
        }
    }

    public void transfer(long amount, SynchronizedAccountMonitorExample accountB) {
        synchronized (lock1) {
            accountB.balance += amount;
            balance -= amount;
        }
    }

    public LocalDate getAccountAnniversary() {
        synchronized (lock2) {
            return accountAnniversary;
        }
    }

    public void updateAccountAnniversary() {
        synchronized (lock2) {
            this.accountAnniversary = LocalDate.now();
        }
    }
}
