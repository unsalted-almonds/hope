package com.shilin.hope.dp;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Example Given S = "rabbbit", T = "rabbit", return 3.
 * 
 * @author Shilin
 *
 */
public class DistinctSubSeq {
	/**
	 * @param S,
	 *            T: Two string.
	 * @return: Count the number of distinct subsequences
	 */
	public int numDistinct(String S, String T) {
		// write your code here

		if (S == null || T == null || S.length() < T.length()) {
			return 0;
		}

		int solution[][] = new int[S.length() + 1][T.length() + 1];

		solution[0][0] = 1;

		for (int i = 1; i < solution.length; i++) {
			solution[i][0] = 1;
		}

		for (int i = 1; i < solution[0].length; i++) {
			solution[0][i] = 0;
		}

		for (int i = 1; i < solution.length; i++) {
			for (int j = 1; j <= i && j < solution[0].length; j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					solution[i][j] = solution[i - 1][j - 1] + solution[i - 1][j];
				} else {
					solution[i][j] = solution[i - 1][j];
				}
			}
		}

		return solution[S.length()][T.length()];
	}
}
