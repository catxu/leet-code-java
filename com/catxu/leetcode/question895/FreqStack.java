package com.catxu.leetcode.question895;

import java.util.*;

/**
 * 895. Maximum Frequency Stack
 */
class FreqStack {

    // 记录val-freq
    private final Map<Integer, Integer> freqMap = new HashMap<>();
    // 嵌套栈，stacks中的每个元素都是一个stack
    private final List<Deque<Integer>> stacks = new ArrayList<>(2 * 1_0000);

    public void push(int val) {
        int times = freqMap.getOrDefault(val, 0);
        if (times == stacks.size()) {
            stacks.add(new ArrayDeque<>());
        }
        stacks.get(times).push(val);
        freqMap.put(val, times + 1);
    }

    public int pop() {
        Deque<Integer> stack = stacks.getLast();
        Integer val = stack.pop();
        if (stack.isEmpty()) stacks.removeLast();
        freqMap.merge(val, -1, Integer::sum);
        return val;
    }
}

/*
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
