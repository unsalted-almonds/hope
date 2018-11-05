package com.pecan.hope.bitwiseandmath;

/**
 * Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 * <p>
 * Example
 * Given n = 3, there are a total of 5 unique BST's.
 * <p>
 * 1           3    3       2      1
 * \         /    /       / \      \
 * 3      2     1       1   3      2
 * /      /       \                  \
 * 2     1          2                  3
 * Created by Shilin_Gan on 4/24/2017.
 */
public class UniqueBST {

    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here

        if (n < 0) {
            return 0;
        }

        int[] count = new int[n + 1];

        // empty tree
        count[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                count[i] += count[j - 1] * count[i - j];
            }
        }

        return count[n];
    }
}
