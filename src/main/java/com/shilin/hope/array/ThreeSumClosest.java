package com.shilin.hope.array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * <p>
 * Notice
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2
 * + 1 = 2).
 *
 * @author Shilin_Gan
 */
public class ThreeSumClosest {

    public static void main(String args[]) {

        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 3;

        new ThreeSumClosest().threeSumClosest(numbers, target);
    }

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target   : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int result = Integer.MAX_VALUE;
        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int minDiff = Integer.MAX_VALUE;

        while (p1 < numbers.length - 2) {
            p2 = p1 + 1;
            p3 = numbers.length - 1;

            while (p2 < p3) {
                int sum = numbers[p1] + numbers[p2] + numbers[p3];
                int diff = target - sum;
                if (minDiff > Math.abs(diff)) {
                    if (diff == 0) {
                        return sum;
                    }
                    minDiff = Math.abs(diff);
                    result = sum;
                }

                // target greater than sum
                // increase sum by moving p2 forward
                if (diff > 0) {
                    p2++;
                }
                // target less than sum
                // decrease sum by moving p3 backward
                else {
                    p3--;
                }
            }
            p1++;
        }

        return result;

    }

}
