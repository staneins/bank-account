package com.kaminsky;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private int accountNumber;
    private AtomicInteger balance = new AtomicInteger(0);
    private Random random = new Random();


    public BankAccount(int sum) {
        this.accountNumber = random.nextInt();
        this.balance = new AtomicInteger(sum);
    }

    public void deposit(int sum) {
        balance.addAndGet(sum);
    }

    public void withdraw(int sum) {
        balance.addAndGet(-sum);
    }

    public int getBalance(){
        return balance.get();
    }
}
