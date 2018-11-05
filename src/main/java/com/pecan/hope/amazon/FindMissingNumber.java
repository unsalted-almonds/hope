package com.pecan.hope.amazon;

/**
 * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 * Created by Shilin_Gan on 11/20/2017.
 */
public class FindMissingNumber {

    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int findMissing(int[] nums) {
        // write your code here

        int mask = 0;

        for (int i = 1; i <= nums.length; i++) {
            mask = mask ^ i;
        }

        for (int n : nums) {
            mask = mask ^ n;
        }

        return mask;
    }
}
