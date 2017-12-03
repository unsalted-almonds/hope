package com.shilin.hope.yama;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

 Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

 The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

 The right-most node is also defined by the same way with left and right exchanged.

 Example 1

 Input:
 1
 \
 2
 / \
 3   4

 Ouput:
 [1, 3, 4, 2]

 Explanation:
 The root doesn't have left subtree, so the root itself is left boundary.
 The leaves are node 3 and 4.
 The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 So order them in anti-clockwise without duplicates and we have [1,3,4,2].


 Example 2

 Input:
 ____1_____
 /          \
 2            3
 / \          /
 4   5        6
 / \      / \
 7   8    9  10

 Ouput:
 [1,2,4,7,8,9,10,6,3]

 Explanation:
 The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 The leaves are node 4,7,8,9,10.
 The right boundary are node 1,3,6,10. (10 is the right-most node).
 So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
public class BoundaryOfBinaryTree {

    public static void main(String[] args) {

        BoundaryOfBinaryTree test = new BoundaryOfBinaryTree();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node4.right = node8;
        node3.left = node6;
        node6.left = node9;
        node6.right = node10;

        System.out.println(test.getBoundary(root));

        test.printBoundary(root);
    }

    private List<Integer> getBoundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        res.add(root.val);

        List<Integer> left = getLeft(root);
        List<Integer> right = getRight(root);
        List<Integer> leaves = getLeaves(root);

        res.addAll(left);

        if (left.size() > 0) {
            leaves.remove(0);
        }

        if (right.size() > 0) {
            leaves.remove(leaves.size() - 1);
        }
        res.addAll(leaves);

        for (int i = right.size() - 1; i >= 0; i--) {
            res.add(right.get(i));
        }

        return res;
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode tmp = stack.pop();
            if (tmp.left == null && tmp.right == null) {
                res.add(tmp.val);
            }
            current = tmp.right;
        }

        return res;
    }

    // left boundary without root
    private List<Integer> getLeft(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        root = root.left;
        while (root != null) {
            res.add(root.val);
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return res;
    }

    // right boundary without root
    private List<Integer> getRight(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        root = root.right;

        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return res;
    }



    TreeNode root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode node)
    {
        if (node != null)
        {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.val + " ");
            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(TreeNode node)
    {
        if (node != null)
        {
            if (node.left != null)
            {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.val + " ");
                printBoundaryLeft(node.left);
            }
            else if (node.right != null)
            {
                System.out.print(node.val + " ");
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode node)
    {
        if (node != null)
        {
            if (node.right != null)
            {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.val + " ");
            }
            else if (node.left != null)
            {
                printBoundaryRight(node.left);
                System.out.print(node.val + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(TreeNode node)
    {
        if (node != null)
        {
            System.out.print(node.val + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }

}
