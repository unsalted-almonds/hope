package com.pecan.hope.yama;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode" return 0.
 * <p>
 * s = "loveleetcode", return 2. Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueInString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (record[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
