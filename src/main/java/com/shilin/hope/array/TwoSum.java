package com.shilin.hope.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are NOT zero-based.
 * 
 * @author Shilin
 *
 */
public class TwoSum {
	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
		// write your code here

		int[] ans = new int[2];

		if (numbers == null || numbers.length < 2) {
			return ans;
		}

		Map<Integer, Integer> diff = new HashMap<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {

			if (diff.containsKey(numbers[i])) {
				ans[0] = diff.get(numbers[i]) + 1;
				ans[1] = i + 1;
				return ans;
			}

			diff.put(target - numbers[i], i);
		}

		return ans;

	}
}
