package com.shilin.hope.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BSTSerialization {
	private static final String EMPTY_NODE_VAL = "#"; 
	
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
	
	private void serializeHelper(TreeNode root, StringBuffer sb) {
		if (root == null) {
			sb.append(",").append(EMPTY_NODE_VAL);
			return;
		}
		
		sb.append(",").append(root.val);
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}
		
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here    
        if (root == null) {
            return "";
        }
        
    	StringBuffer sb = new StringBuffer("");
    	serializeHelper(root, sb);
    	
    	return sb.substring(1);
    }
    
    private void deserializeHelper(TreeNode root, Queue<String> values) {
    	if (root == null) {
    		return;
    	}
    	
    	String leftValue = values.poll();
    	if (leftValue.equals(EMPTY_NODE_VAL)) {
    		deserializeHelper(null, values);
    	} else {
    		root.left = new TreeNode(Integer.parseInt(leftValue));
    		deserializeHelper(root.left, values);
    	}
    	
    	String rightValue = values.poll();
    	if (rightValue.equals(EMPTY_NODE_VAL)) {
    		deserializeHelper(null, values);
    	} else {
    		root.right = new TreeNode(Integer.parseInt(rightValue));
    		deserializeHelper(root.right, values);
    	}
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
    	
    	Queue<String> values = new LinkedList<String>(Arrays.asList(data.split(",")));
    	
    	TreeNode root = new TreeNode(Integer.parseInt(values.poll()));
    	
    	deserializeHelper(root, values);
    	
    	return root;

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
