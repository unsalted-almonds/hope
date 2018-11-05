package com.pecan.hope.yama;

import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in
 * the set got duplicated to another number in the set, which results in repetition of one number and loss of another
 * number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number
 * occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3] Note: The given array size will in the range [2, 10000]. The given
 * array's numbers won't have any order.
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        Set<Integer> count = new HashSet<>();
        for (int n : nums) {
            if (count.contains(n)) {
                res[0] = n;
            } else {
                count.add(n);
            }
        }


        for (int i = 1; i <= nums.length; i++) {
            if (!count.contains(i)) {
                res[1] = i;
                break;
            }
        }

        return res;
    }
}
