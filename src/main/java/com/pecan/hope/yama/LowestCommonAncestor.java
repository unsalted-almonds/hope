package com.pecan.hope.yama;

import java.util.*;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * _______3______ /              \ ___5__          ___1__ /      \        /      \ 6      _2       0       8 /  \ 7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition. Created by Shilin_Gan on 12/14/2017.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor test = new LowestCommonAncestor();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;

        TreeNode res = test.lowestCommonAncestor(root, root, left);

        System.out.println(res);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return root;

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        search(root, p, new ArrayList<>(), pPath);
        if (pPath.isEmpty()) return null;

        search(root, q, new ArrayList<>(), qPath);
        if (qPath.isEmpty()) return null;

        return lowestCommonAncestorFromPaths(pPath, qPath);
    }

    private void search(TreeNode root, TreeNode node, List<TreeNode> path, List<TreeNode> solution) {
        if (root == null) {
            return;
        }

        path.add(root);

        if (root == node) {
            solution.addAll(new ArrayList<>(path));
            return;
        }

        search(root.left, node, path, solution);

        if (!solution.isEmpty()) return;

        search(root.right, node, path, solution);

        path.remove(path.size() - 1);
    }


    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        parents.put(root, null);
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            TreeNode current = bfs.poll();
            if (current.left != null) {
                bfs.offer(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                bfs.offer(current.right);
                parents.put(current.right, current);
            }
        }

        List<TreeNode> pathP = getPath(parents, p);
        if (pathP.isEmpty()) return null;

        List<TreeNode> pathQ = getPath(parents, q);
        if (pathQ.isEmpty()) return null;

        return lowestCommonAncestorFromPaths(pathP, pathQ);
    }

    private TreeNode lowestCommonAncestorFromPaths(List<TreeNode> pathA, List<TreeNode> pathB) {
        TreeNode prev = null;
        int i = 0;
        for (; i < pathA.size() && i < pathB.size(); i++) {
            if (pathA.get(i) != pathB.get(i)) return prev;
            prev = pathA.get(i);
        }
        return prev;
    }

    private List<TreeNode> getPath(Map<TreeNode, TreeNode> parents, TreeNode node) {
        List<TreeNode> res = new LinkedList<>();
        while (node != null) {
            res.add(0, node);
            node = parents.get(node);
        }
        return res;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left != null && right != null) {
            return root;
        }

        return (right == null) ? left : right;

    }

}
