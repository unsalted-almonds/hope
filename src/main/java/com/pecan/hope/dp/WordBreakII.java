package com.pecan.hope.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。 返回所有有可能的句子。
 * <p>
 * 您在真实的面试中是否遇到过这个题？ Yes 样例 给一字串lintcode,字典为["de", "ding", "co", "code", "lint"] 则结果为["lint code", "lint co de"]。
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();

        if (s == null || wordDict == null) {
            return res;
        }

        int n = s.length();
        boolean[] canBreak = new boolean[n + 1];
        canBreak[n] = true;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (wordDict.contains(s.substring(i, j + 1)) && canBreak[j + 1]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        if (canBreak[0] == false) return res;


        helper(s, wordDict, 0, new ArrayList<>(), res);

        return res;

    }


    private void helper(String s, Set<String> wordDict, int idx, List<String> path, List<String> solution) {

        if (idx > s.length() - 1) {
            StringBuilder res = new StringBuilder();
            for (String str : path) {
                res.append(str).append(" ");
            }
            solution.add(res.substring(0, res.length() - 1));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String subStr = s.substring(idx, i + 1);
            if (wordDict.contains(subStr)) {
                path.add(subStr);
                helper(s, wordDict, i + 1, path, solution);
                path.remove(path.size() - 1);
            }
        }
    }
}
