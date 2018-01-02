package com.shilin.hope.yama;

import java.util.Arrays;

/**
 * Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class RotateFunction {
    public static void main(String[] args) {
        RotateFunction test = new RotateFunction();

        int[] input = new int[]{1,2,3,4,5};
        test.rotateByOne(input);

        System.out.println(Arrays.toString(input));
    }

    public int maxRotateFunction(int[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }

        int sum = 0;
        for (int n : A) {
            sum += n;
        }

        res = Integer.MIN_VALUE;

        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp += i * A[i];
        }

        res = Math.max(res, tmp);
        int prev = tmp;
        for (int i = A.length - 1; i >= 0; i--) {
            res = Math.max(res, sum - A.length * A[i] + prev);
            prev = sum - A.length * A[i] + prev;
        }

        return res;

    }


    public int maxRotateFunction2(int[] A) {
        int res = 0;
        if (A == null || A.length == 0) {
            return res;
        }
        res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int tmp = 0;
            for (int k = 0; k < A.length; k++) {
                tmp += A[k] * k;
            }

            res = Math.max(res, tmp);
            rotateByOne(A);
        }

        return res;
    }

    private void rotateByOne(int[] A) {
        int newVal = A[0];

        for (int i = 1; i < A.length; i++) {
            int tmp = A[i];
            A[i] = newVal;
            newVal = tmp;
        }

        A[0] = newVal;
    }
}
