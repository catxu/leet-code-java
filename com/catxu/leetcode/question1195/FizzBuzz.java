package com.catxu.leetcode.question1195;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 */
class FizzBuzz {
    private final int n;
    private final Semaphore number = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);

    private final CountDownLatch latch;

    public FizzBuzz(int n) {
        this.n = n;
        this.latch = new CountDownLatch(n);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (latch.getCount() > 0) {
            fizz.acquire();
            if (latch.getCount() == 0) {
                return;
            }
            printFizz.run();
            latch.countDown();
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (latch.getCount() > 0) {
            buzz.acquire();
            if (latch.getCount() == 0) {
                return;
            }
            printBuzz.run();
            latch.countDown();
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (latch.getCount() > 0) {
            fizzbuzz.acquire();
            if (latch.getCount() == 0) {
                return;
            }
            printFizzBuzz.run();
            latch.countDown();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            number.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
                continue;
            } else if (i % 3 == 0) {
                fizz.release();
                continue;
            } else if (i % 5 == 0) {
                buzz.release();
                continue;
            }
            printNumber.accept(i);
            latch.countDown();
            number.release();
        }
        // 通知阻塞线程
        fizz.release();
        buzz.release();
        fizzbuzz.release();
    }
}
