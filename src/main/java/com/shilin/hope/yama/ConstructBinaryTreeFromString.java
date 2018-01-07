package com.shilin.hope.yama;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.

 The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

 You always start to construct the left child node of the parent first if it exists.

 Example:

 Input: "4(2(3)(1))(6(5))"
 Output: return the tree root node representing the following tree:

 4
 /   \
 2     6
 / \   /
 3   1 5


 Note:

 There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 An empty tree is represented by "" instead of "()".
 */
public class ConstructBinaryTreeFromString {

    public static void main(String[] args) {
        ConstructBinaryTreeFromString test = new ConstructBinaryTreeFromString();

        System.out.println(test.strToTree("4(2(3)(1))(6(5))"));
    }

    public TreeNode strToTree(String s) {
        return helper(s);
    }

    private TreeNode helper(String s) {

        if (s.length() == 0) {
            return null;
        }

        int leftStart = s.indexOf('(');
        int rootVal;
        if (leftStart == -1) {
            rootVal = Integer.valueOf(s);
            return new TreeNode(rootVal);
        }

        rootVal = Integer.valueOf(s.substring(0, leftStart));

        TreeNode root = new TreeNode(rootVal);

        int count = 0;
        int leftEnd = -1;

        for (int i = leftStart; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count == 0) {
                leftEnd = i;
                break;
            }
        }

        root.left = helper(s.substring(leftStart + 1, leftEnd));

        if (leftEnd < s.length() - 1) {
            root.right = helper(s.substring(leftEnd + 2, s.length() - 1));
        }

        return root;

    }
}
