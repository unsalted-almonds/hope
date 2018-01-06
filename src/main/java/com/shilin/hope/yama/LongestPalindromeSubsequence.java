package com.shilin.hope.yama;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s
 * is 1000.
 * <p>
 * Example 1: Input:
 * <p>
 * "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb". Example 2: Input:
 * <p>
 * "cbbd" Output: 2 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }

        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 + dp[i + 1][j - 1] : Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][s.length() - 1];
    }

    /**
     * public:
     int longestPalindromeSubseq(string s) {
     int n = s.size();
     vector<vector<int>> memo(n, vector<int>(n, -1));
     return helper(s, 0, n - 1, memo);
     }
     int helper(string& s, int i, int j, vector<vector<int>>& memo) {
     if (memo[i][j] != -1) return memo[i][j];
     if (i > j) return 0;
     if (i == j) return 1;
     if (s[i] == s[j]) {
     memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
     } else {
     memo[i][j] = max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
     }
     return memo[i][j];
     }
     */
}
