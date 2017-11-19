package com.shilin.hope.amazon;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * Have you met this question in a real interview? Yes Example a = 11
 * <p>
 * b = 1
 * <p>
 * Return 100
 */
public class AddBinary {

    /*
  * @param a: a number
  * @param b: a number
  * @return: the result
  */
    public String addBinary(String a, String b) {
        // write your code here
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }

        int[] res = new int[Math.max(a.length(), b.length()) + 1];

        int resIdx = res.length - 1;
        int bIdx = b.length() - 1;
        int aIdx = a.length() - 1;
        int carry = 0;

        // not really need to use an array to store results
        // use string directly is pretty suffcient
        while (bIdx >= 0 || aIdx >= 0) {
            int digitA = (aIdx >= 0) ? getBinary(a.charAt(aIdx)) : 0;
            int digitB = (bIdx >= 0) ? getBinary(b.charAt(bIdx)) : 0;

            res[resIdx] = digitA + digitB + carry;
            carry = res[resIdx] / 2;
            res[resIdx] %= 2;

            aIdx--;
            bIdx--;
            resIdx--;
        }

        res[resIdx] = carry;

        StringBuilder sb = new StringBuilder();

        resIdx = 0;
        while (resIdx < res.length - 1 && res[resIdx] == 0) {
            resIdx++;
        }

        for (int i = resIdx; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }

    private int getBinary(char c) {
        if (c == '0') {
            return 0;
        }

        return 1;
    }
}
