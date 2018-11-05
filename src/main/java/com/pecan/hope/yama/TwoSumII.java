package com.pecan.hope.yama;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        if (numbers == null || numbers.length < 2) {
            return res;
        }

        int p1 = 0, p2 = numbers.length - 1;

        while (p1 < p2) {
            int sum = numbers[p1] + numbers[p2];

            if (sum == target) {
                res[0] = ++p1;
                res[1] = ++p2;
                return res;
            }

            if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }

        return res;
    }
}
