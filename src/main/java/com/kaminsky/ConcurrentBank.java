package com.kaminsky;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentBank {
    private ReentrantLock lock = new ReentrantLock();
    private AtomicInteger totalBalance = new AtomicInteger(0);

    public BankAccount createAccount(int i) {
        totalBalance.addAndGet(i);
        return new BankAccount(i);
    }

    public void transfer(BankAccount account1, BankAccount account2, int i) {
        try {
            lock.lock();
            account1.withdraw(i);
            account2.deposit(i);
        } finally {
            lock.unlock();
        }
    }

    public int getTotalBalance() {
        return totalBalance.get();
    }
}
