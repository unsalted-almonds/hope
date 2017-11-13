package com.shilin.hope.amazon;

/**
 * 给定一个array A[], length of A[], two values(n1 和n2), first, to compute a BST, then compute the distance between these
 * two nodes in the BST.
 * <p>
 * Given a list of unique integers, construct the binary tree by given order without rebalancing, then find out the
 * distance between two nodes.
 * <p>
 * public static int bstDistance(int[] values, int n, int node1, int node2) for example, values= [5,6,3,1,2,4], n is the
 * size of values, node1 is 2, node2 is 4, then function return 3 构建完BST如下，2和4呢，距离就是3. 鍥磋鎴戜滑@1point 3 acres 5 3      6
 * 1 4 2
 */
public class BSTDistance {

    public static void main(String[] args) {
        int res = bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 2, 6);

        System.out.println(res);
    }

    public static int bstDistance(int[] values, int n, int node1, int node2) {
        int result = Integer.MAX_VALUE;

        if (values == null || values.length == 0) {
            return result;
        }

        if (node1 == node2) {
            return 0;
        }

        Node root = toBST(values);

        if (search(root, node1) == Integer.MAX_VALUE || search(root, node2) == Integer.MAX_VALUE) {
            return result;
        }

        int[] range = new int[2];
        if (node1 > node2) {
            range[0] = node2;
            range[1] = node1;
        } else {
            range[0] = node1;
            range[1] = node2;
        }

        Node commonAncester = root;
        while (commonAncester != null) {

            if (commonAncester.val == range[0] || commonAncester.val == range[1]) {
                break;
            }
            if (commonAncester.val > range[0] && commonAncester.val < range[1]) {
                break;
            }
            if (commonAncester.val < range[0]) {
                commonAncester = commonAncester.right;
            } else if (commonAncester.val > range[1]) {
                commonAncester = commonAncester.left;
            }
        }

        return search(commonAncester, node1) + search(commonAncester, node2);

    }

    private static Node toBST(int[] values) {
        Node root = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            insert(root, values[i]);
        }
        return root;
    }

    /**
     * return number of steps
     *
     * @param root
     * @param n
     * @return
     */
    private static int search(Node root, int n) {
        int result = 0;
        while (root != null) {
            if (root.val == n) {
                return result;
            }
            if (root.val > n) {
                root = root.left;
            } else {
                root = root.right;
            }
            result++;
        }

        return Integer.MAX_VALUE;
    }

    private static void insert(Node root, int n) {
        Node prev = root;

        while (root != null) {
            prev = root;
            if (n < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (prev.val > n) {
            prev.left = new Node(n);
        } else {
            prev.right = new Node(n);
        }

    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
