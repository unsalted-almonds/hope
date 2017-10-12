package com.shilin.hope.palindrome;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        // write your code here
        Set<Character> record = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (record.contains(s.charAt(i))) {
                record.remove(s.charAt(i));
                continue;
            }

            record.add(s.charAt(i));
        }

        if (record.size() > 0) {
            return s.length() - record.size() + 1;
        }

        return s.length();
    }
}
