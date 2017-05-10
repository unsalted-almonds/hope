package com.shilin.hope.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 * 
 * @author Shilin
 *
 */
public class LargestNumber {
	/**
	 * @param num:
	 *            A list of non negative integers
	 * @return: A string
	 */
	public String largestNumber(int[] num) {
		// write your code here
		String[] strs = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			strs[i] = Integer.toString(num[i]);
		}
		Arrays.sort(strs, new NumbersComparator());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}
		String result = sb.toString();
		int index = 0;
		while (index < result.length() && result.charAt(index) == '0') {
			index++;
		}
		if (index == result.length()) {
			return "0";
		}
		return result.substring(index);

	}

	class NumbersComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return (s2 + s1).compareTo(s1 + s2);
		}
	}
}
