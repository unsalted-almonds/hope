package com.shilin.hope.yama;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a
 * subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    // sliding window
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        if (s == null || s.length() == 0) {
            return res;
        }

        int left = 0, right = 0;
        Set<Character> unique = new HashSet<>();

        while (right < s.length()) {
            while (right < s.length() && !unique.contains(s.charAt(right))) {
                unique.add(s.charAt(right));
                right++;
            }

            res = Math.max(res, unique.size());

            // move left to remove s.charAt(right)
            while (right < s.length() && unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++;
            }


        }
        return res;

    }
}
