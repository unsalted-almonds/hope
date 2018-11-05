package com.pecan.hope.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 40,000.
 * <p>
 * The order of output does not matter.
 */
public class FindAllAnagramsInString {

    public static void main(String[] args) {

        System.out.println(new FindAllAnagramsInString().findAnagrams("abcdefabcdef", "edc"));

    }

    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */

    // try using window to do this one
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int startIdx = 0;
        int endIdx = p.length();

        while (endIdx <= s.length()) {

            String tmp = s.substring(startIdx, endIdx);
            if (isAnagrams(tmp, p)) {
                result.add(startIdx);
            }
            startIdx++;
            endIdx++;
        }

        return result;

    }

    private boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        return Arrays.equals(s1Array, s2Array);
    }
}
