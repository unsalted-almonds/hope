package com.pecan.hope.yama;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up: Could you solve it with constant space complexity? (Note: The output array does not count as extra space
 * for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }


        int[] res = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = product * nums[i];
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                res[i] = product;
                continue;
            }
            res[i] = res[i - 1] * product;
            product *= nums[i];
        }

        return res;

    }
}
