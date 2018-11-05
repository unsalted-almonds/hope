package com.pecan.hope.binarytree;


/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author Shilin
 *
 */
public class ConstructBinaryTreePreoderInorder {
	
	public static void main(String args[]) {
		new ConstructBinaryTreePreoderInorder().buildTree(new int[]{1,2,4,5,3,6,7}, new int[]{4,2,5,1,6,3,7});
	}
	
	/**
	 * @param preorder
	 *            : A list of integers that preorder traversal of a tree
	 * @param inorder
	 *            : A list of integers that inorder traversal of a tree
	 * @return : Root of a tree
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// write your code here
		if (preorder == null || preorder.length == 0) {
			return null;
		}

		return buildTreeHelper(preorder[0], preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

	}
	/*
	 * 10 5 15 6 12 20
	 * 
	 * preorder 10 5 6 15 12 20 inorder 5 6 10 12 15 20
	 */

	/*
	 * 1 2 preorder 1 2 inorder 1 2
	 */
	private TreeNode buildTreeHelper(int rootVal, int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
			int inorderStart, int inorderEnd) {
		
		System.out.println("rootVal = " + rootVal);
		System.out.println("preorderStart = " + preorderStart + ", preorderEnd = " + preorderEnd + ", inorderStart = " + inorderStart +", inorderEnd = " + inorderEnd);
		
		TreeNode root = new TreeNode(rootVal);
		int rootIndexInorder = findValue(rootVal, inorder); // 2 1
		int leftSubTreeSize = rootIndexInorder - inorderStart; // 2 1

		int preorderNewStart = preorderStart + 1; // 1 2
		int preorderNewEnd = preorderNewStart + leftSubTreeSize - 1; // 2 2

		int inorderNewStart = rootIndexInorder - leftSubTreeSize; // 0 0
		int inorderNewEnd = rootIndexInorder - 1; // 1 0


		if (leftSubTreeSize == 1) {
			System.out.println("created left " + inorder[inorderStart]);
			root.left = new TreeNode(inorder[inorderStart]);
		} else if (leftSubTreeSize != 0) {
			System.out.println("left >> preorderNewStart = " + preorderNewStart + ", preorderNewEnd = " + preorderNewEnd + ", inorderNewStart = " + inorderNewStart + ", inorderNewEnd = " + inorderNewEnd);
			root.left = buildTreeHelper(preorder[preorderNewStart], preorder, preorderNewStart, preorderNewEnd, inorder,
					inorderNewStart, inorderNewEnd);
		}

		int rightSubTreeSize = inorderEnd - rootIndexInorder;

		preorderNewStart = preorderStart + leftSubTreeSize + 1;
		preorderNewEnd = preorderNewStart + rightSubTreeSize - 1;

		inorderNewStart = rootIndexInorder + 1;
		inorderNewEnd = inorderNewStart + rightSubTreeSize - 1;

		if (rightSubTreeSize == 1) {
			System.out.println("created right " + inorder[inorderEnd]);
			root.right = new TreeNode(inorder[inorderEnd]);
		} else if (rightSubTreeSize != 0) {
			System.out.println("right >> preorderNewStart = " + preorderNewStart + ", preorderNewEnd = " + preorderNewEnd + ", inorderNewStart = " + inorderNewStart + ", inorderNewEnd = " + inorderNewEnd);

			root.right = buildTreeHelper(preorder[preorderNewStart], preorder, preorderNewStart,
					preorderNewEnd, inorder, inorderNewStart, inorderNewEnd);
		}

		return root;
	}

	private int findValue(int value, int[] values) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] == value) {
				return i;
			}
		}

		return -1;
	}
	
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
}
