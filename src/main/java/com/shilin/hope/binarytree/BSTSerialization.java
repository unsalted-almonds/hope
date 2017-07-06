package com.shilin.hope.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTSerialization {
	
	public static void main(String args[]) {
		
		BSTSerialization test = new BSTSerialization();
		
		TreeNode root = test.new TreeNode(1);
		root.left = test.new TreeNode(2);
		root.right = test.new TreeNode(3);
		root.right.left = test.new TreeNode(4);
		root.right.right = test.new TreeNode(5);
		
		System.out.println(test.serialize(root));
		
		//System.out.println(test.deserialize("1,2,#,#,3,4,#,#,5,#,#"));
		
		System.out.println(test.serialize(test.deserialize("1,2,#,#,3,4,#,#,5,#,#")));
	}
	
	private static final String EMPTY_NODE_VAL = "#"; 
	
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
    	/*
        StringBuffer sb = new StringBuffer();
        
        if (root == null) {
            return sb.toString();
        }
        
        // perform a level traversal (bfs)
        Queue<TreeNode> level = new LinkedList<TreeNode>();
        level.offer(root);
        String nullString = "null";
        
        Boolean hasNode = true;
        
        while (hasNode) {
        	hasNode = false;
            Queue<TreeNode> children = new LinkedList<TreeNode>();
            while (!level.isEmpty()) {
                TreeNode parent = level.poll();
                sb.append(",");
                if (parent == null) {
                    sb.append(nullString);
                    children.offer(null);
                    children.offer(null);
                } else {
                    sb.append(parent.val);
                    children.offer(parent.left);
                    children.offer(parent.right);
                    if (parent.left != null || parent.right!=null) {
                    	hasNode = true;
                    }
                }
            }
            level = children;
        }
        
        return sb.substring(1);
        */
    	
        StringBuffer sb = new StringBuffer("");
        
        if (root == null) {
            return sb.toString();
        }
        
        Stack<TreeNode> stackFrame = new Stack<TreeNode>();
        
        stackFrame.push(root);
        
		while (!stackFrame.isEmpty()) {

			TreeNode stackTop = stackFrame.pop();
			sb.append(",");
			if (stackTop == null) {
				sb.append(EMPTY_NODE_VAL);
			} else {
				sb.append(stackTop.val);

				if (stackTop.right != null) {
					stackFrame.push(stackTop.right);
				} else {
					stackFrame.push(null);
				}
				
				if (stackTop.left != null) {
					stackFrame.push(stackTop.left);
				} else {
					stackFrame.push(null);
				}
			}

		}
        
        return sb.substring(1);
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    
    // "1,2,#,#,3,4,#,#,5,#,#"
    public TreeNode deserialize(String data) {
        // write your code here
    	
    	if (data == null || data.length() == 0) {
    		return null;
    	}
    	
    	Queue<String> preOrder = new LinkedList<String>(Arrays.asList(data.split(",")));
    	System.out.println(preOrder);
    	
    	TreeNode root = new TreeNode(Integer.parseInt(preOrder.poll()));
    	TreeNode current = root;
    	
    	while (!preOrder.isEmpty()) {
    		String value = preOrder.poll();
    		
    		if (!value.equals(EMPTY_NODE_VAL)) {
    			current.left = new TreeNode(Integer.parseInt(value));
    			current = current.left;
    		} else {
    			value = preOrder.poll();
    			if (!value.equals(EMPTY_NODE_VAL)) {
    				current.right = new TreeNode(Integer.parseInt(value));
    				current = current.right;
    			} else if (!preOrder.isEmpty()) {
    				current = new TreeNode(Integer.parseInt(preOrder.poll()));
    			}
    		}
    		
    	}
    	
    	return root;
    	/*
        TreeNode result = null;
        
        if (data.length() == 0) {
            return result;
        }
        
        String[] tokens = data.split(",");
        System.out.println(Arrays.toString(tokens));
        result = new TreeNode(Integer.parseInt(tokens[0]));
        Integer i = 1;
        Queue<TreeNode> parent = new LinkedList<TreeNode>();
        parent.offer(result);
        
        while (i < tokens.length) {
            Queue<TreeNode> children = new LinkedList<TreeNode>();
            while (!parent.isEmpty()) {
                TreeNode node = parent.poll();
                if (node == null) {
                    i = i + 2;
                    break;
                }
                if (tokens[i].equals("null")) {
                    children.offer(null);
                } else {
                    node.left = new TreeNode(Integer.parseInt(tokens[i])); 
                    children.offer(node.left);
                }
                i++;
                
                if (tokens[i].equals("null")) {
                    children.offer(null);
                } else {
                    node.right = new TreeNode(Integer.parseInt(tokens[i])); 
                    children.offer(node.right);
                }
                i++;
            }
            parent = children;
            
        }
        return result;
        */
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
