package com.shilin.hope.yama;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
 * contain duplicate words.
 * <p>
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please
 * reload the code definition to get the latest changes.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        Set<String> dictSet = new HashSet<>(wordDict);
        int maxDictLength = maxWordLength(dictSet);

        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;

        for (int i = 1; i < res.length; i++) {
            String substring = "";
            for (int j = i; j > 0 && substring.length() < maxDictLength; j--) {
                substring = s.charAt(j - 1) + substring;
                if (dictSet.contains(substring) && res[j - 1]) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[res.length - 1];

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

    // dfs time out
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        Set<String> dictSet = new HashSet<>();
        int minLen = 0;
        int maxLen = 0;
        for (String str : wordDict) {
            minLen = Math.min(str.length(), minLen);
            maxLen = Math.max(str.length(), maxLen);
            dictSet.add(str);
        }

        if (s.length() < minLen) {
            return false;
        }

        return helper(s, minLen, maxLen, dictSet);
    }

    private boolean helper(String s, int minLen, int maxLen, Set<String> dictSet) {
        if (dictSet.contains(s)) {
            return true;
        }

        for (int i = minLen; i <= s.length(); i++) {
            if (i > maxLen) break;
            String tmp = s.substring(0, i);
            if (dictSet.contains(tmp)) {
                if (i == s.length()) {
                    return true;
                } else {
                    if (helper(s.substring(i), minLen, maxLen, dictSet)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
