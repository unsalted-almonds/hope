package com.shilin.hope.greedy;

import java.util.Arrays;

/**
 * Given a list of integers, which denote a permutation.
 * 
 * Find the next permutation in ascending order.
 * 
 * 
 * Example For [1,3,2,3], the next permutation is [1,3,3,2]
 * 
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 * 
 * @author Shilin
 *
 */

/**
 * great O(n) solution
 * @author Shilin
 *
 */
public class NextPermutation {
	
	public static void main(String args[]){
		
		System.out.println(Arrays.toString(new NextPermutation().nextPermutation(new int[]{1,3,2})));
		
		
		
	}
	/**
	 * @param nums:
	 *            an array of integers
	 * @return: An array of integers that's next permuation
	 */
	   public int[] nextPermutation(int[] nums) {
	        // write your code here
	        
	        if (nums == null || nums.length == 0) {
	            return nums;
	        }
	        
	        int i;
	        int j;
	        for (i = nums.length - 1; i >= 1; i--) {
	            if (nums[i] > nums[i-1]) {
	                for (j = nums.length - 1; j > i && nums[j] <= nums[i-1]; j--) {}
	                swap(nums, j, i-1);
	                reverseArray(nums, i, nums.length - 1);
	                break;
	            }
	        }
	        
	        if (i == 0) {
	            reverseArray(nums);
	        }
	        
	        return nums;
	        
	    }
	    
	    private void reverseArray (int[] nums) {
	        reverseArray(nums, 0, nums.length - 1);
	    }
	    
	    
	    // need to know how to reverse an array 
	    private void reverseArray(int[] nums, int start, int end){
	        int i = start;
	        int j = end;
	        while (i < j) {
	            swap(nums, i++, j--);
	        }
	    }
	    
	    private void swap (int[] nums, int a, int b) {
	        int tmp = nums[a];
	        nums[a] = nums[b];
	        nums[b] = tmp;
	    }
}
