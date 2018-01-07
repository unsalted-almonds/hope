package com.shilin.hope.yama;

/**
 * https://www.youtube.com/watch?v=i9_K0h93PF8
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring test = new LongestPalindromeSubstring();

        System.out.println(test.longestPalindrome("abcba"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        int maxLen = 1;
        String res = new Character(s.charAt(0)).toString();

        int size = s.length();
        boolean[][] match = new boolean[size][size];

        // take care of one element and two elements
        for (int i = 0; i < size; i++) {
            match[i][i] = true;
            if (i + 1 < size && s.charAt(i) == s.charAt(i + 1)) {
                match[i][i + 1] = true;
                maxLen = 2;
                res = s.substring(i, i + 2);
            }
        }

        // up bottom is very difficult to write
        // bottom up is easier
        for (int i = size - 3; i >= 0; i--) {
            for (int j = i + 2; j < size; j++) {
                if (match[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    match[i][j] = true;
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }


}
