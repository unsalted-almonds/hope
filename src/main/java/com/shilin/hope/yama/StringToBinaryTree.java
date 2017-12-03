package com.shilin.hope.yama;

import java.util.Arrays;

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
public class StringToBinaryTree {

    public static void main(String[] args) {
        StringToBinaryTree test = new StringToBinaryTree();
        System.out.println(Arrays.toString(test.getSubTreesStr("4(2(3)(1))(6(5))")));
        TreeNode root = test.toBinaryTree("4(2(3)(1))(6(5))");
        System.out.println("root = " + root.val);
        System.out.println("root.left = " + root.left.val);
        System.out.println("root.right = " + root.right.val);
        System.out.println("left.left = " + root.left.left.val);
        System.out.println("left.right = " + root.left.right.val);
        System.out.println("right.left = " + root.right.left.val);
        //System.out.println("right.right = " + root.right.right.val);

        root = test.toBinaryTree("4(-6(5))");
        System.out.println(root);


    }

    public TreeNode toBinaryTree(String str) {

        return constructBinaryTree(str);
    }

    private TreeNode constructBinaryTree(String str) {
        if (str == null) {
            return null;
        }

        int rootValue;
        if (str.indexOf("(") != -1) {
            rootValue = Integer.valueOf(str.substring(0,str.indexOf("(")));
        } else {
            rootValue = Integer.valueOf(str);
        }

        TreeNode rootNode = new TreeNode(rootValue);

        String[] subTrees = getSubTreesStr(str);

        rootNode.left = constructBinaryTree(subTrees[0]);
        rootNode.right = constructBinaryTree(subTrees[1]);

        return rootNode;
    }

    private String[] getSubTreesStr(String str) {
        String[] res = new String[2];
        int start = str.indexOf('(');
        if (start == -1) {
            return res;
        }

        int parenthesis = 0;
        int i = start;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                parenthesis++;
            } else if (str.charAt(i) == ')') {
                parenthesis--;
            }

            if (parenthesis == 0) {
                res[0] = str.substring(start + 1, i);
                break;
            }
        }
        // get right sub tree from rest of the tree;
        if (i == str.length() - 1) {
            return res;
        }

        res[1] = str.substring(i + 2, str.length() - 1);

        return res;
    }

}
