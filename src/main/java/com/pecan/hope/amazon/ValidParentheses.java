package com.pecan.hope.amazon;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 * <p>
 * Have you met this question in a real interview? Yes Example The brackets must close in the correct order, "()" and
 * "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> parentheses = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (parentheses.isEmpty()) {
                if (c == '(' || c == '{' || c == '[') {
                    parentheses.push(c);
                    continue;
                }
                return false;
            }

            switch (c) {
                case ')':
                    if (parentheses.peek() == '(') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (parentheses.peek() == '[') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (parentheses.peek() == '{') {
                        parentheses.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    parentheses.push(c);
            }
        }

        return parentheses.isEmpty();
    }
}
