package com.shilin.hope.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array and a window size that is sliding along the array, find the sum of the count of unique elements in
 * each window.
 * <p>
 * Have you met this question in a real interview? Yes Example Given a array nums = [1, 2, 1, 3, 3] and k = 3
 * <p>
 * First window [1, 2, 1], only 2 is unique, count is 1. Second window [2, 1, 3], all elements unique, count is 3. Third
 * window [1, 3, 3], only 1 is unique, count is 1. sum of count = 1 + 3 + 1 = 5
 * <p>
 * Return 5
 */
public class SlidingWindowUniqueSum {

    public static void main(String[] args) {
        SlidingWindowUniqueSum test = new SlidingWindowUniqueSum();
        System.out.println(test.slidingWindowUniqueElementsSum(new int[]{27, 14, 60, 87, 37, 53, 100, 18, 51, 37, 14, 57, 22, 95, 50, 83, 41, 43, 36, 48, 52, 97, 16, 46, 75, 24, 47, 13, 40, 40, 48, 45, 56, 58, 77, 3, 78, 60, 31, 27, 40, 53, 57, 29, 30, 65, 37, 77, 1, 40, 89, 100, 50, 49, 100, 51, 22, 66, 33, 33, 70, 36, 64, 70, 11, 27, 57, 77, 17, 28, 62, 70, 32, 88, 12, 47, 69, 30, 93, 3, 47, 69, 64, 88, 7, 40, 38, 5, 23, 4, 58, 97, 19, 55, 17, 23}, 21));
    }

    /*
     * @param : the given array
     * @param : the window size
     * @return: the sum of the count of unique elements in each window
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        int res = 0;
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (k > nums.length) {
            return 1;
        }

        Map<Integer, Integer> windowMap = new HashMap<>();

        // construct first window
        for (int i = 0; i < k; i++) {
            if (windowMap.containsKey(nums[i])) {
                windowMap.put(nums[i], windowMap.get(nums[i]) + 1);
            } else {
                windowMap.put(nums[i], 1);
            }
        }

        res += getUniqueSum(windowMap);
        int prev = nums[0];
        int lastResult = res;
        for (int i = 1; i < nums.length - k + 1; i++) {

            int newElement = nums[i + k - 1];

            int prevElementCount = windowMap.get(prev) - 1;
            if (prevElementCount == 0) {
                windowMap.remove(prev);
                lastResult--;
            } else {
                windowMap.put(prev, windowMap.get(prev) - 1);
                if (windowMap.get(prev) == 1) {
                    lastResult++;
                }
            }

            if (windowMap.containsKey(newElement)) {
                if (windowMap.get(newElement) == 1) {
                    lastResult--;
                }
                windowMap.put(newElement, windowMap.get(newElement) + 1);
            } else {
                windowMap.put(newElement, 1);
                lastResult++;
            }

            prev = nums[i];
            res += lastResult;

        }

        return res;
    }

    private int getUniqueSum(Map<Integer, Integer> windowMap) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : windowMap.entrySet()) {
            if (entry.getValue() == 1) {
                res++;
            }
        }

        return res;
    }

}
