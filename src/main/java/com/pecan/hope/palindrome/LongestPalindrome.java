package com.pecan.hope.palindrome;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Notice
 * <p>
 * Assume the length of given string will not exceed 1010.
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given s = "abccccdd" return 7
 * <p>
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
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
