package com.pecan.hope.datastructure;

import java.util.Stack;


/**
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * <p>
 * It should support push, pop and min operation all in O(1) cost.
 * <p>
 * push(1)
 * pop()   // return 1
 * push(2)
 * push(3)
 * min()   // return 2
 * push(1)
 * min()   // return 1
 */
public class MinStack {

    /*
* @param a: An integer
*/
    Stack<ValueAndMin> stack = new Stack<ValueAndMin>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        // do intialization if necessary
        stack = new Stack<ValueAndMin>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        min = Math.min(number, min);
        stack.push(new ValueAndMin(number, min));
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int pop() {
        // write your code here
        ValueAndMin res = stack.pop();
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stack.peek().currentMin;
        }
        return res.value;
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int min() {
        // write your code here
        return stack.peek().currentMin;
    }

    class ValueAndMin {
        int value;
        int currentMin;

        public ValueAndMin(int value, int currentMin) {
            this.value = value;
            this.currentMin = currentMin;
        }
    }
}
