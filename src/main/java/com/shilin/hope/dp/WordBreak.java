package com.shilin.hope.dp;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be break
 * into a space-separated sequence of one or more dictionary words. Given s =
 * "lintcode", dict = ["lint", "code"].
 * 
 * Return true because "lintcode" can be break as "lint code".
 * 
 * lintcode1 -> false
 * 
 * @author Shilin
 *
 */
public class WordBreak {
	/**
	 * @param s:
	 *            A string s
	 * @param dict:
	 *            A dictionary of words dict
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		if (s == null || dict == null) {
			return false;
		}

		int maxDictLength = maxWordLength(dict);
		boolean[] solution = new boolean[s.length() + 1];

		solution[0] = true;

		for (int i = 1; i < solution.length; i++) {
			String substr = "";
			for (int j = i; j > 0 && substr.length() < maxDictLength; j--) {
				substr = s.charAt(j - 1) + substr;
				if (solution[j - 1] && dict.contains(substr)) {
					solution[i] = true;
					break;
				}
			}
		}

		return solution[s.length()];
	}

	private int maxWordLength(Set<String> dict) {
		int result = 0;
		for (String word : dict) {
			if (word.length() > result) {
				result = word.length();
			}
		}
		return result;
	}
}
