package com.pecan.hope.yama;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of the stack. top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack. Example: MinStack minStack = new MinStack();
 * minStack.push(-2); minStack.push(0); minStack.push(-3); minStack.getMin();   --> Returns -3. minStack.pop();
 * minStack.top();      --> Returns 0. minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    Stack<int[]> minStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        int min = x;
        if (!minStack.isEmpty()) {
            min = Math.min(getMin(), x);
        }
        minStack.push(new int[]{x, min});
    }

    public void pop() {
        minStack.pop();
    }

    public int top() {
        return minStack.peek()[0];
    }

    public int getMin() {
        return minStack.peek()[1];
    }
}
