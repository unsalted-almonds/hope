package com.shilin.hope.dp;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one
 * or more dictionary words. Given s = "lintcode", dict = ["lint", "code"].
 * <p>
 * Return true because "lintcode" can be break as "lint code".
 * <p>
 * lintcode1 -> false
 *
 * @author Shilin
 */
public class WordBreak {
    /**
     * @param s:    A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {

        if (s == null || dict == null) {
            return false;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLen = maxWordLength(dict);
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > maxLen) break;
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    continue;
                }
            }
        }

        return dp[dp.length - 1];
    }

    private int maxWordLength(Set<String> dict) {
        int res = 0;

        for (String str : dict) {
            res = Math.max(res, str.length());
        }

        return res;
    }
}
