package com.shilin.hope.yama;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 * as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is
 * the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any
 * order.
 * <p>
 * Examples 1 Input:
 * <p>
 * 5 /  \ 2   -3 return [2, -3, 4], since all the values happen only once, return all of them in any order. Examples 2
 * Input:
 * <p>
 * 5 /  \ 2   -5 return [2], since 2 happens twice, however -5 only occur once. Note: You may assume the sum of values
 * in any subtree is in the range of 32-bit signed integer.
 */
public class FrequentSubTreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        Map<Integer, Integer> count = new HashMap<>();

        subTreeSum(root, count);

        int max = 0;
        Set<Integer> resSet = new HashSet<>();

        for (Integer key : count.keySet()) {
            if (count.get(key) > max) {
                resSet = new HashSet<>();
                resSet.add(key);
                max = count.get(key);
            } else if (count.get(key) == max) {
                resSet.add(key);
            }
        }

        int[] res = new int[resSet.size()];

        int idx = 0;
        for (Integer n : resSet) {
            res[idx++] = n;
        }

        return res;

    }

    private Integer subTreeSum(TreeNode root, Map<Integer, Integer> count) {

        Integer leftSum = 0, rightSum = 0;
        if (root.left != null) {
            leftSum = subTreeSum(root.left, count);
        }
        if (root.right != null) {
            rightSum = subTreeSum(root.right, count);
        }

        Integer res = root.val + leftSum + rightSum;

        if (count.containsKey(res)) {
            count.put(res, count.get(res) + 1);
        } else {
            count.put(res, 1);
        }

        return res;

    }

}
