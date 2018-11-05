package com.pecan.hope.combinatorics;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example, If n = 4 and k = 2, a solution is:
 * <p>
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k > n) {
            return res;
        }

        helper(res, new ArrayList<>(), 1, n, k);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> combo, int start, int n, int k) {

        if (combo.size() == k) {
            res.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i <= n; i++) {
            combo.add(i);
            helper(res, combo, i + 1, n, k);
            combo.remove(combo.size() - 1);
        }
    }
}
