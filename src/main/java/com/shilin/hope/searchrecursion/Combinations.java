package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * Created by Shilin_Gan on 7/20/2017.
 */
public class Combinations {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (n < k) {
            return result;
        }

        List<Integer> combo = new ArrayList<Integer>(k);

        helper(result, combo, n, k, 1);

        return result;

    }


    private void helper(List<List<Integer>> result, List<Integer> combo, int n, int k, int start){
        if (combo.size() == k) {
            result.add(new ArrayList<Integer>(combo));
            return;
        }

        for (int i = start; i <= n; i++){
            combo.add(i);
            helper(result, combo, n, k, i + 1);
            combo.remove(combo.size()-1);
        }

    }

}
