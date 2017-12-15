package com.shilin.hope.yama;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class BinaryTreeSerialization {

    public static void main(String args[]) {

        BinaryTreeSerialization test = new BinaryTreeSerialization();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(test.serialize(root));
        System.out.println(test.deserialize(test.serialize(root)));
        //System.out.println(test.deserialize("1,2,#,#,3,4,#,#,5,#,#"));

        //System.out.println(test.serialize(test.deserialize("1,2,#,#,3,4,#,#,5,#,#")));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        // preorder
        preorder(root, res);
        // inorder
        inorder(root, res);

        return res.substring(1);
    }

    private void inorder(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.append(",").append(root.val);
        inorder(root.right, res);
    }

    private void preorder(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }

        res.append(",").append(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] token = data.split(",");

        int currentPreorder = 0;
        int currentInorder = token.length / 2;

        return findRoot(currentPreorder, currentInorder, token.length - 1, token);
    }

    private TreeNode findRoot(int preorder, int inorderStart, int inorderEnd, String[] token) {
        if (preorder < 0 || preorder >= token.length || inorderStart < 0 || inorderStart >= token.length || inorderEnd < 0 || inorderEnd >= token.length || inorderStart > inorderEnd) {
            return null;
        }

        String rootStr = token[preorder];

        int inorderRoot = inorderStart;

        for (int i = inorderStart; i < token.length; i++) {
            if (token[i].equals(rootStr)) {
                inorderRoot = i;
                break;
            }
        }

        TreeNode root = new TreeNode(Integer.valueOf(rootStr));
        int leftSubTreeSize = 0;
        int leftSubTreePreorder = -1;
        if (inorderRoot > inorderStart) {
            leftSubTreeSize = inorderRoot - inorderStart;
            leftSubTreePreorder = preorder + 1;
        }

        root.left = findRoot(leftSubTreePreorder, inorderStart, inorderRoot - 1, token);

        //int rightSubTreeSize = 0;
        int rightSubTreePreorder = -1;
        if (inorderRoot < inorderEnd) {
            rightSubTreePreorder = preorder + leftSubTreeSize + 1;
        }

        root.right = findRoot(rightSubTreePreorder, inorderRoot + 1, inorderEnd, token);

        return root;
    }


    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!bfs.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            boolean hasNextLevel = false;
            while (!bfs.isEmpty()) {
                TreeNode current = bfs.poll();
                if (current == null) {
                    sb.append(",#");
                    // also add its children
                    nextLevel.offer(null);
                    nextLevel.offer(null);
                    continue;
                }

                sb.append(",").append(current.val);
                nextLevel.offer(current.left);
                nextLevel.offer(current.right);

                hasNextLevel = (current.left != null) || (current.right != null) || hasNextLevel;
            }
            if (!hasNextLevel) break;

            bfs = nextLevel;
        }

        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] token = data.split(",");

        int parent = 0;
        int children = 1;

        TreeNode root = new TreeNode(Integer.valueOf(token[parent]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (children < token.length) {
            String parentStr = token[parent];
            if (parentStr.equals("#")) {
                parent++;
                children += 2;
                continue;
            }

            TreeNode parentNode = q.poll();
            String leftStr = token[children];
            if (!leftStr.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(leftStr));
                parentNode.left = leftNode;
                q.offer(leftNode);
            }
            String rightStr = token[++children];
            if (!rightStr.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(rightStr));
                parentNode.right = rightNode;
                q.offer(rightNode);
            }
            parent++;
            children++;
        }
        return root;
    }
}
