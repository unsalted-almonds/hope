package com.shilin.hope.amazon;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Have you met this question in a real interview? Yes Example Given [1,2,3] which represents 123, return [1,2,4].
 * <p>
 * Given [9,9,9] which represents 999, return [1,0,0,0].
 */
public class PlusOne {
    /*
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (carry == 0) {
            return digits;
        }

        int[] res = new int[digits.length + 1];

        res[0] = 1;

        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }

        return res;
    }

}
