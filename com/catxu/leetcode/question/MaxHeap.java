package com.catxu.leetcode.question;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    // 构造函数1：创建空堆
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // 构造函数2：通过数组直接构建堆（heapify）
    public MaxHeap(int[] arr) {
        heap = new ArrayList<>();
        for (int num : arr) {
            heap.add(num);
        }
        heapify(); // 关键步骤：堆化调整
    }

    // 插入元素并上浮调整
    public void push(int value) {
        heap.add(value);
        bubbleUp(heap.size() - 1);
    }

    // 弹出堆顶元素（最大值）并下沉调整
    public int pop() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap.getFirst(); // 堆顶元素
        int lastElement = heap.removeLast(); // 移除最后一个元素
        if (!heap.isEmpty()) {
            heap.set(0, lastElement); // 将最后一个元素移到堆顶
            bubbleDown(0); // 从根节点开始下沉调整
        }
        return root;
    }

    // 核心方法：heapify操作（将任意数组调整为堆）
    private void heapify() {
        int size = heap.size();
        // 从最后一个非叶子节点开始，向前遍历到根节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            bubbleDown(i); // 对每个节点执行下沉操作
        }
    }

    // 下沉操作（核心逻辑）
    private void bubbleDown(int currentIndex) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1; // 左子节点索引
            int rightChildIndex = 2 * currentIndex + 2; // 右子节点索引
            int largestIndex = currentIndex;

            // 比较左子节点和当前节点
            if (leftChildIndex < size && heap.get(leftChildIndex) > heap.get(largestIndex)) {
                largestIndex = leftChildIndex;
            }

            // 比较右子节点和当前最大值
            if (rightChildIndex < size && heap.get(rightChildIndex) > heap.get(largestIndex)) {
                largestIndex = rightChildIndex;
            }

            // 如果子节点比当前节点大，则交换并继续下沉
            if (largestIndex != currentIndex) {
                swap(currentIndex, largestIndex);
                currentIndex = largestIndex;
            } else {
                break; // 堆性质已满足，退出循环
            }
        }
    }

    // 上浮操作（与之前代码一致）
    private void bubbleUp(int currentIndex) {
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex) > heap.get(parentIndex)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // 交换元素
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // 示例用法
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.push(10);
        maxHeap.push(5);
        maxHeap.push(3);
        maxHeap.push(15);
        System.out.println("初始堆: " + maxHeap.heap); // [15, 10, 3, 5]

        // 弹出堆顶元素（最大值）
        int max = maxHeap.pop();
        System.out.println("弹出最大值: " + max); // 15
        System.out.println("弹出后的堆: " + maxHeap.heap); // [10, 5, 3]
    }
}
