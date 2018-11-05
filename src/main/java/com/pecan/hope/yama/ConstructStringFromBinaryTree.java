package com.pecan.hope.yama;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing
 * way.
 * <p>
 * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis
 * pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
 * <p>
 * Example 1: Input: Binary tree: [1,2,3,4] 1 /   \ 2     3 / 4
 * <p>
 * Output: "1(2(4))(3)"
 * <p>
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty
 * parenthesis pairs. And it will be "1(2(4))(3)". Example 2: Input: Binary tree: [1,2,3,null,4] 1 /   \ 2     3 \ 4
 * <p>
 * Output: "1(2()(4))(3)"
 * <p>
 * Explanation: Almost the same as the first example, except we can't omit the first parenthesis pair to break the
 * one-to-one mapping relations
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        }

        if (t.left == null && t.right == null) {
            return "" + t.val;
        }

        if (t.right == null) {
            return "" + t.val + "(" + tree2str(t.left) + ")";
        }

        return "" + t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";

    }

    public String tree2str2(TreeNode t) {
        String res = "";

        if (t == null) {
            return res;
        }

        return helper(t);
    }

    private String helper(TreeNode t) {
        // 1(2()(4))(3)
        if (t.left == null && t.right != null) {
            return "" + t.val + "()(" + helper(t.right) + ")";
        } else if (t.left == null && t.right == null) {
            return "" + t.val;
        } else if (t.left != null && t.right == null) {
            return "" + t.val + "(" + helper(t.left) + ")";
        } else {
            return "" + t.val + "(" + helper(t.left) + ")(" + helper(t.right) + ")";
        }

    }
}
