package com.shilin.hope.dp;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * Insert a character Delete a character Replace a character Have you met this
 * question in a real interview? Yes Example Given word1 = "mart" and word2 =
 * "karma", return 3.
 * 
 * 
 * video https://www.youtube.com/watch?v=Xxx0b7djCrs
 * 
 * @author Shilin
 *
 */
public class EditDistances {
	/**
	 * @param word1
	 *            & word2: Two string.
	 * @return: The minimum number of steps.
	 */
	public int minDistance(String word1, String word2) {
		// write your code here

		int[][] minDistances = new int[word1.length() + 1][word2.length() + 1];

		minDistances[0][0] = 0;

		for (int i = 1; i <= word1.length(); i++) {
			minDistances[i][0] = i;
		}

		for (int i = 1; i <= word2.length(); i++) {
			minDistances[0][i] = i;
		}

		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				minDistances[i][j] = Math.min(Math.min(minDistances[i - 1][j] + 1, minDistances[i][j - 1] + 1),
						word1.charAt(i - 1) == word2.charAt(j - 1) ? minDistances[i - 1][j - 1]
								: minDistances[i - 1][j - 1] + 1);
			}
		}

		return minDistances[word1.length()][word2.length()];
	}
}
