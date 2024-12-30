package com.catxu.leetcode.question155;

import java.util.Stack;

/**
 * 155. Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * Implement the MinStack class:
 * <p>
 * MinStack() initializes the stack object.
 * <p>
 * void push(int val) pushes the element val onto the stack.
 * <p>
 * void pop() removes the element on the top of the stack.
 * <p>
 * int top() gets the top element of the stack.
 * <p>
 * int getMin() retrieves the minimum element in the stack.
 * <p>
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Example 1:
 * <p>
 * Input
 *
 * <pre>
 *     {@code
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *     }
 * </pre>
 * <p>
 * Output
 *
 * <pre>
 *     {@code
 * [null,null,null,null,-3,null,0,-2]
 *     }
 * </pre>
 * <p>
 * Explanation
 *
 * <pre>
 *  {@code
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *  }
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * -2<sup>31</sup> <= val <= 2<sup>31</sup> - 1
 * <p>
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * <p>
 * At most 3 * 10<sup>4</sup> calls will be made to push, pop, top, and getMin.
 */
class MinStack {

    private final Stack<Integer> minStack;
    private final Stack<Integer> self;

    public MinStack() {
        this.self = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        self.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = self.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return self.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.getMin());
        obj.push(3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
