package com.catxu.leetcode.question1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 1116. Print Zero Even Odd
 */
class ZeroEvenOdd {
    private final int n;

    ReentrantLock lock = new ReentrantLock();
    Condition enableZero = lock.newCondition();
    Condition enableOdd = lock.newCondition();
    Condition enableEven = lock.newCondition();
    int flag = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (flag != 0) {
                    enableZero.await();
                }
                printNumber.accept(0);
                if (i % 2 == 0) {
                    flag = 2;
                    // print even
                    enableEven.signalAll();
                } else {
                    flag = 1;
                    // print odd
                    enableOdd.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag != 2) {
                    enableEven.await();
                }
                printNumber.accept(i);
                flag = 0;
                enableZero.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag != 1) {
                    enableOdd.await();
                }
                printNumber.accept(i);
                flag = 0;
                enableZero.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
