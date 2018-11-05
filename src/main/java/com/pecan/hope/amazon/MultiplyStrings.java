package com.pecan.hope.amazon;


/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only digits 0-9. Both num1 and num2 does not
 * contain any leading zero. You must not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }

        int[] num1Arr = new int[num1.length()];
        int[] num2Arr = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            num1Arr[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            num2Arr[i] = num2.charAt(i) - '0';
        }

        int[] resArr = new int[num1Arr.length + num2Arr.length];

        for (int i = num1Arr.length - 1; i >= 0; i--) {
            int carry = 0;
            int j;
            for (j = num2Arr.length - 1; j >= 0; j--) {
                resArr[i + j + 1] += num1Arr[i] * num2Arr[j] + carry;
                carry = resArr[i + j + 1] / 10;
                resArr[i + j + 1] = resArr[i + j + 1] % 10;
            }
            // most significant
            resArr[i + j + 1] += carry;
        }

        int i = 0;
        while (i < resArr.length && resArr[i] == 0) i++;

        if (i == resArr.length) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < resArr.length; j++) {
            sb.append(resArr[j]);
        }

        return sb.toString();
    }
    /*
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }

        int[] num1Arr = new int[num1.length()];
        int[] num2Arr = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            num1Arr[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            num2Arr[i] = num2.charAt(i) - '0';
        }

        long solution = 0;
        long k = 1;
        for (int i = num1Arr.length - 1; i >= 0; i--) {
            long ten = 1;
            long carry = 0;
            long res = 0;

            for (int j = num2Arr.length - 1; j > 0; j--) {
                long tmp = num1Arr[i] * num2Arr[j];
                long digit = (tmp % 10 + carry) % 10;
                carry = tmp / 10 + (((tmp % 10 + carry) >= 10) ? 1 : 0);
                res += digit * ten;
                ten *= 10;
            }
            // when j == 0
            res += (num1Arr[i] * num2Arr[0] + carry) * ten;
            solution += res * k;
            k *= 10;
        }

        return "" + solution;
    }
*/
}
