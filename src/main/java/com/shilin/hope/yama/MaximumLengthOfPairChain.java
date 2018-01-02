package com.shilin.hope.yama;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in
 * this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You
 * can select pairs in any order.
 * <p>
 * Example 1: Input: [[1,2], [2,3], [3,4]] Output: 2 Explanation: The longest chain is [1,2] -> [3,4] Note: The number
 * of given pairs will be in the range [1, 1000].
 */
public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        MaximumLengthOfPairChain test = new MaximumLengthOfPairChain();

        int res = test.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}});

        System.out.println(res);
    }

    public int findLongestChain(int[][] pairs) {
        int res = 0;

        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        // sort based on the second element
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] set1, int[] set2) {
                return Integer.compare(set1[1], set2[1]);
            }
        };

        Arrays.sort(pairs, comp);
        int max = pairs[0][1];
        res = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > max) {
                max = pairs[i][1];
                res++;
            }
        }

        return res;

    }

    public int findLongestChain2(int[][] pairs) {
        int res = 0;

        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        // sort based on the second element
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] set1, int[] set2) {
                return Integer.compare(set1[1], set2[1]);
            }
        };

        Arrays.sort(pairs, comp);

        int[] solution = new int[pairs.length];

        for (int i = 0; i < solution.length; i++) {
            int[] pair = pairs[i];
            int j = i - 1;
            while (j >= 0) {
                if (pair[0] > pairs[j][1]) {
                    solution[i] = Math.max(solution[i], solution[j] + 1);
                }
                j--;
            }
            if (solution[i] == 0) solution[i] = 1;

            res = Math.max(solution[i], res);

        }

        return res;

    }
}
