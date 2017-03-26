package com.shilin.hope.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Example For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * 
 * (-1, 0, 1) (-1, -1, 2)
 * 
 * @author Shilin_Gan
 *
 */
public class ThreeSum {

	// pay attention to how calculation is reduced by checking for duplicates
	// this needs to be thought through

	public static void main(String args[]) {

		System.out.println(new ThreeSum().threeSum(new int[] { -1, 1, 0 }));

	}

	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		// write your code here

		// [-1 0 1 2 -1 -4]
		// n!/(3!*(n-3)!) -> n * n - 1 * n-2 -> n^3

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		if (numbers == null || numbers.length < 3) {
			return ans;
		}

		Arrays.sort(numbers);

		for (int i = 0; i < numbers.length; i++) {

			// this situation can be skipped as all possible combinations have
			// been explored with last iteration
			// this skip may improve algorithm in real life substantially
			if (i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = numbers.length - 1;

			while (j < k) {
				int sum = numbers[i] + numbers[j] + numbers[k];

				if (sum == 0) {

					ans.add(new ArrayList<Integer>(Arrays.asList(numbers[i], numbers[j], numbers[k])));
					k--;
					j++;

					// skip duplicate pairs
					while (j < k && numbers[k] == numbers[k + 1]) {
						k--;
					}
					// skip duplicate pairs
					while (j < k && numbers[j] == numbers[j - 1]) {
						j++;
					}

				} else if (sum > 0) {
					k--;
					/*
					 * it's ok to not skip since it doesn't really improve the
					 * algorithm while (j < k && numbers[k] == numbers[k+1]){
					 * k--; }
					 */
				} else {
					j++;
					/*
					 * it's ok to not skip since it doesn't really improve the
					 * algorithm while (j < k && numbers[j] == numbers[j-1]){
					 * j++; }
					 */
				}

			}

		}

		return ans;

	}
}
