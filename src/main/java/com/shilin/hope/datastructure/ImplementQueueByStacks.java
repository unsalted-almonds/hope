package com.shilin.hope.datastructure;

import java.util.Stack;

/**
 * As the title described, you should only use two stacks to implement a queue's actions.
 * <p>
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * <p>
 * Both pop and top methods should return the value of first element.
 * <p>
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 */
public class ImplementQueueByStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByStacks() {
        // do intialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            reverseStack(stack1, stack2);
        }

        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            reverseStack(stack1, stack2);
        }

        return stack2.peek();
    }

    private void reverseStack(Stack<Integer> fromStack, Stack<Integer> toStack) {
        while (!fromStack.isEmpty()) {
            toStack.push(fromStack.pop());
        }
    }
}
