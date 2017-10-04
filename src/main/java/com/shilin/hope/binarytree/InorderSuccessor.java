package com.shilin.hope.binarytree;

/**
 * In Binary Tree, Inorder successor of a node is the next node in Inorder
 * traversal of the Binary Tree. Inorder Successor is NULL for the last node in
 * Inoorder traversal. In Binary Search Tree, Inorder Successor of an input node
 * can also be defined as the node with the smallest key greater than the key of
 * input node. So, it is sometimes important to find next node in sorted order.
 * 
 * @author Shilin
 *
 */
public class InorderSuccessor {

	public Node nextNode(Node current, Node root) {
		
		if (current.right != null) {
			return findMinFromRight(current);
		}
		
		while (!isRoot(current)) {
			if (isLeftChild(current)) {
				return current.parent;
			}
			current = current.parent;
		}
		
		return null;

	}
	
	private boolean isRoot(Node current) {
		return current.parent == null;
	}
	
	private boolean isLeftChild(Node current){
		Node parent = current.parent;
		return parent.left.data == current.data;
	}
	
	private Node findMinFromRight(Node current) {
		Node result = current.right;
		while (result.left != null) {
			result = result.left;
		}
		return result;
	}

	// Java program to find minimum value node in Binary Search Tree

	// A binary tree node
	class Node {

		int data;
		Node left, right, parent;

		Node(int d) {
			data = d;
			left = right = parent = null;
		}

	}
}