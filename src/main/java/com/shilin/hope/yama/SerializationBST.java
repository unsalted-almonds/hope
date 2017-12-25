package com.shilin.hope.yama;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SerializationBST {

    public static void main(String[] args) {
        SerializationBST test = new SerializationBST();

        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;

        System.out.println(test.serialize(root));
        System.out.println(test.deserialize(test.serialize(root)));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder preorder = preorder(root);
        return preorder.substring(0, preorder.length() - 1);
    }

    private StringBuilder preorder(TreeNode root) {
        StringBuilder res = new StringBuilder();

        Stack<TreeNode> preorder = new Stack<>();
        preorder.push(root);

        while (!preorder.isEmpty()) {
            TreeNode current = preorder.pop();
            res.append(current.val).append(",");
            if (current.right != null) {
                preorder.push(current.right);
            }
            if (current.left != null) {
                preorder.push(current.left);
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] preorderString = data.split("\\s*,\\s*");
        List<Integer> preorder = new ArrayList<>();

        for (String str : preorderString) {
            preorder.add(Integer.valueOf(str));
        }

        return helper(new TreeNode(preorder.get(0)), 0, preorder.size() - 1, preorder);

    }

    private TreeNode helper(TreeNode root, Integer start, Integer end, List<Integer> preorder) {

        Integer leftStart = -1, rightStart = -1, leftEnd = end, rightEnd = end;
        for (int i = start + 1; i <= end; i++) {
            if (i == start + 1 && preorder.get(i) < root.val) {
                leftStart = i;
            }
            if (preorder.get(i) > root.val) {
                if (leftStart != -1) {
                    leftEnd = i - 1;
                }
                rightStart = i;
                break;
            }
        }

        if (leftStart != -1) {
            root.left = helper(new TreeNode(preorder.get(leftStart)), leftStart, leftEnd, preorder);
        }
        if (rightStart != -1) {
            root.right = helper(new TreeNode(preorder.get(rightStart)), rightStart, rightEnd, preorder);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

