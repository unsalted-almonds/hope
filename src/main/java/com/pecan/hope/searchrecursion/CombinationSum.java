package com.pecan.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
 * numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Notice
 * <p>
 * All numbers (including target) will be positive integers. Elements in a combination (a1, a2, ?? , ak) must be in
 * non-descending order. (ie, a1 ?? a2 ?? ?? ?? ak). The solution set must not contain duplicate combinations.
 * <p>
 * Example Given candidate set [2,3,6,7] and target 7, a solution set is:
 * <p>
 * [7] [2, 2, 3]
 *
 * @author Shilin
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        helper(result, new ArrayList<Integer>(), target, 0, 0, deDupe(candidates));

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> solution, int target, int startIdx, int sum, int[] candidates) {

        if (sum == target) {
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            solution.add(candidates[i]);
            helper(result, solution, target, i, sum + candidates[i], candidates);
            solution.remove(solution.size() - 1);
        }

    }

    // dedupe a sorted array
    private int[] deDupe(int[] input) {
        int index = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] != input[index]) {
                index++;
                input[index] = input[i];
            }
        }

        int[] result = new int[index + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = input[i];
        }

        return result;
    }
}























