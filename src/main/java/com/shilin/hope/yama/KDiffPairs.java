package com.shilin.hope.yama;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a
 * k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * <p>
 * Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2 Explanation: There are two 2-diff pairs in the array, (1, 3) and
 * (3, 5). Although we have two 1s in the input, we should only return the number of unique pairs. Example 2: Input:[1,
 * 2, 3, 4, 5], k = 1 Output: 4 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4,
 * 5). Example 3: Input: [1, 3, 1, 5, 4], k = 0 Output: 1 Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note: The pairs (i, j) and (j, i) count as the same pair. The length of the array won't exceed 10,000. All the
 * integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KDiffPairs {

    public static void main(String[] args) {
        KDiffPairs test = new KDiffPairs();
        test.findPairs(new int[]{1, 2, 3, 4, 5}, 2);
    }

    public int findPairs(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length <= 1 || k < 0) {
            return res;
        }

        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            if (count.containsKey(n)) {
                count.put(n, count.get(n) + 1);
            } else {
                count.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    res++;
                }
            } else {
                if (count.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }

        return res;
    }

    public int findPairs2(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length <= 1) {
            return res;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = 1;

        while (end < nums.length) {
            int diff = nums[end] - nums[start];
            if (diff == k) {
                res++;
                end++;
                start++;
                while (end < nums.length && nums[end] == nums[end - 1]) end++;
            } else if (diff > k) {
                start++;
                if (start == end)
                    end++;
            } else {
                end++;
            }
        }

        return res;

    }
}
