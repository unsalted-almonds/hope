package com.shilin.hope.datastructure;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {

    /*
 * @param n: An integer
 * @return: the nth prime number as description.
 */
    public int nthUglyNumber(int n) {
        // write your code here
        // form ugly number from 2, 3, 5
        if (n < 0) {
            return -1;
        }

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        List<Integer> result = new ArrayList<Integer>(n);

        result.add(1);

        for (int i = 0; i < n; i++) {
            int last = result.get(i);

            while (result.get(p2) * 2 <= last) {
                p2++;
            }

            while (result.get(p3) * 3 <= last) {
                p3++;
            }

            while (result.get(p5) * 5 <= last) {
                p5++;
            }

            int current = Math.min(Math.min(result.get(p2) * 2, result.get(p3) * 3), result.get(p5) * 5);

            result.add(current);
        }

        return result.get(n - 1);

    }

/*
    public int nthUglyNumber(int n) {
        // write your code here

        // ugly number
        // prime number

        int i = 1;
        int resultSize = 0;
        int result = 1;

        while (resultSize < n) {
            if (isUgly(i)) {
                result = i;
                resultSize++;
            }
            i++;
        }

        return result;

    }

    private boolean isUgly(int num) {

        // 2 serves as divisor
        while (num % 2 == 0) {
            num = num/2;
        }

        while (num % 3 == 0) {
            num = num/3;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }
    */

}
