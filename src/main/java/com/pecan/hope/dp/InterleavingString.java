package com.pecan.hope.dp;

/**
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the
 * interleaving of s1 and s2. Example For s1 = "aabcc", s2 = "dbbca"
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author Shilin
 *
 */
public class InterleavingString {
	/*
	 * @param s1: A string
	 * 
	 * @param s2: A string
	 * 
	 * @param s3: A string
	 * 
	 * @return: Determine whether s3 is formed by interleaving of s1 and s2
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		// write your code here
		if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] solution = new boolean[s1.length() + 1][s2.length() + 1];
		solution[0][0] = true;

		for (int i = 1; i < solution.length; i++) {
			if (solution[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
				solution[i][0] = true;
			}
		}

		for (int i = 1; i < solution[0].length; i++) {
			if (solution[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
				solution[0][i] = true;
			}
		}

		for (int i = 1; i < solution.length; i++) {
			for (int j = 1; j < solution[0].length; j++) {
				if (solution[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
						|| solution[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					solution[i][j] = true;
				}
			}
		}

		return solution[s1.length()][s2.length()];
	}
}
