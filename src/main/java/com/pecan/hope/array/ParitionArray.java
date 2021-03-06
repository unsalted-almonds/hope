package com.pecan.hope.array;

/**
 * Given an array nums of integers and an int k, partition the array (i.e move
 * the elements in "nums") such that:
 * 
 * All elements < k are moved to the left All elements >= k are moved to the
 * right Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 * Notice
 * 
 * You should do really partition in array nums instead of just counting the
 * numbers of integers smaller than k.
 * 
 * If all elements in nums are smaller than k, then return nums.length
 * 
 * Example If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * 
 * @author Shilin
 *
 */
public class ParitionArray {
	/**
	 * @param nums:
	 *            The integer array you should partition
	 * @param k:
	 *            As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		// write your code here

		// [3 2 2 1] k = 2
		// [1 2 2 3] return 1

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int ans = nums.length;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				if (i > ans) {
					swap(nums, i, ans);
					ans++;
				}
			} else {
				if (ans == nums.length) {
					ans = i;
				}
			}
		}

		return ans;
	}

	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	

	// jiuzhang
	
//	public class Solution {
//	    /** 
//	     *@param nums: The integer array you should partition
//	     *@param k: As description
//	     *return: The index after partition
//	     */
//	    public int partitionArray(int[] nums, int k) {
//	        if(nums == null || nums.length == 0){
//	            return 0;
//	        }
//	        
//	        int left = 0, right = nums.length - 1;
//	        while (left <= right) {
//
//	            while (left <= right && nums[left] < k) {
//	                left++;
//	            }
//
//	            while (left <= right && nums[right] >= k) {
//	                right--;
//	            }
//
//	            if (left <= right) {
//	                int temp = nums[left];
//	                nums[left] = nums[right];
//	                nums[right] = temp;
//	                
//	                left++;
//	                right--;
//	            }
//	        }
//	        return left;
//	    }
//	}
}
