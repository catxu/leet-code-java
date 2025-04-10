package com.catxu.leetcode.question1114;

import java.util.concurrent.CountDownLatch;

/**
 * 1114. Print in Order
 */
class Foo {

    public Foo() {
    }

    final Object lock = new Object();
    int cnt = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (cnt != 0) {
                lock.wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            cnt++;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (cnt != 1) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            cnt++;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (cnt != 2) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printThird.run();
            cnt++;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Running Test Case 1: input = [1, 2, 3] ---");
        runTestCase(new int[]{1, 2, 3});

        // 添加一些分隔，使得输出更清晰
        System.out.println("\n-----------------------------------------");

        System.out.println("--- Running Test Case 2: input = [1, 3, 2] ---");
        runTestCase(new int[]{1, 3, 2});

        System.out.println("\n-----------------------------------------");
        System.out.println("All test cases finished.");
    }

    // 辅助方法，用于运行单个测试用例
    public static void runTestCase(int[] nums) {
        // 为每个测试用例创建新的 Foo 实例
        Foo foo = new Foo();
        // 使用 CountDownLatch 确保主线程等待所有工作线程执行完毕
        CountDownLatch latch = new CountDownLatch(3);

        // 根据 nums 数组创建并启动线程
        Thread threadA = createThread(foo, nums[0], latch);
        Thread threadB = createThread(foo, nums[1], latch);
        Thread threadC = createThread(foo, nums[2], latch);

        // 启动线程 (启动顺序不影响最终输出顺序)
        threadA.start();
        threadB.start();
        threadC.start();

        // 等待所有线程执行完毕
        try {
            latch.await(); // 等待 latch 计数归零
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting.");
            Thread.currentThread().interrupt();
        }
        System.out.println(); // 在测试用例输出后换行
    }

    // 辅助方法，根据输入的数字创建对应的线程
    private static Thread createThread(Foo foo, int methodNumber, CountDownLatch latch) {
        Runnable task;
        switch (methodNumber) {
            case 1:
                task = () -> {
                    try {
                        foo.first(() -> System.out.print("first"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown(); // 确保线程结束时减少 latch 计数
                    }
                };
                break;
            case 2:
                task = () -> {
                    try {
                        foo.second(() -> System.out.print("second"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                };
                break;
            case 3:
                task = () -> {
                    try {
                        foo.third(() -> System.out.print("third"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        latch.countDown();
                    }
                };
                break;
            default:
                // 如果输入无效，创建一个什么都不做的线程，并减少 latch 计数
                task = latch::countDown;
                System.err.println("Warning: Invalid method number " + methodNumber);
        }
        return new Thread(task);
    }
}