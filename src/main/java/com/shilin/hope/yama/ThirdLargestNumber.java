package com.shilin.hope.yama;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the
 * maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1: Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1. Example 2: Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead. Example 3: Input: [2, 2, 3,
 * 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number. Both numbers with value 2 are
 * both considered as second maximum.
 */
public class ThirdLargestNumber {
    public int thirdMax(int[] nums) {
        // nums is not empty

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int n : nums) {
            if (n > first) {
                long tmp = first;
                first = n;
                third = second;
                second = tmp;
                continue;
            }

            if (n < first && n > second) {
                third = second;
                second = n;
                continue;
            }

            if (n < second && n > third) {
                third = n;
                continue;
            }
        }

        return third == Long.MIN_VALUE ? (int) (long) first : (int) (long) third;
    }
}
