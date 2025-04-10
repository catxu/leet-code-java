package com.catxu.leetcode.question1115;

/**
 * 1115. Print FooBar Alternately
 */
class FooBar {
    private final int n;
    private volatile boolean permit = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!permit) {
                Thread.yield();
            }
            printFoo.run();
            permit = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++ ) {
            while (permit) {
                Thread.yield();
            }
            printBar.run();
            permit = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(3);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1_000L);
    }
}
