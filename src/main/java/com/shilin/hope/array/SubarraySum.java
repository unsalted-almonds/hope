package com.shilin.hope.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the
 * last number.
 * 
 * Example Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * 
 * @author Shilin
 *
 */

// this is interesting and not very obvious at first glance. good way of thinking and observing patterns and stuff.
public class SubarraySum {
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public ArrayList<Integer> subarraySum(int[] nums) {
		// write your code here

		ArrayList<Integer> ans = new ArrayList<Integer>();

		if (nums == null || (nums.length == 1 && nums[0] != 0)) {
			return ans;
		}

		if (nums.length == 1 && nums[0] == 0) {
			ans.add(0);
			ans.add(0);
			return ans;
		}

		// [-3, 1, 2, -3, 4]
		// [-3, -2, 0, -3, 1]

		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		
		// when zero appears, it means it starts from the very beginning, and -1 here is for using the algorithm
		sumMap.put(0, -1);

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (sumMap.containsKey(sum)) {
				ans.add(sumMap.get(sum) + 1);
				ans.add(i);
				return ans;
			}

			sumMap.put(sum, i);

		}

		return ans;

	}
}
