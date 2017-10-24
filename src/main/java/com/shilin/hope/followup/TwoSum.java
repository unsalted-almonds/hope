package com.shilin.hope.followup;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 */
public class TwoSum {
    /**
     * @param nums:   an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[2];
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];

            if (sum == target) {
                result[0] = ++p1;
                result[1] = ++p2;
                return result;
            } else if (sum < target) {
                p1++;
                continue;
            } else {
                p2--;
                continue;
            }
        }

        return result;
    }


}
