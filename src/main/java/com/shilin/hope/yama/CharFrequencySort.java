package com.shilin.hope.yama;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "tree"
 * <p>
 * Output: "eert"
 * <p>
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'.
 * Therefore "eetr" is also a valid answer. Example 2:
 * <p>
 * Input: "cccaaa"
 * <p>
 * Output: "cccaaa"
 * <p>
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note that "cacaca" is
 * incorrect, as the same characters must be together. Example 3:
 * <p>
 * Input: "Aabb"
 * <p>
 * Output: "bbAa"
 * <p>
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two
 * different characters.
 */
public class CharFrequencySort {

    public static void main(String[] args) {
        CharFrequencySort test = new CharFrequencySort();

        String res = test.frequencySort("Aabb");

        System.out.println(res);
    }

    public String frequencySort(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int[] freq = new int[256];

        // if there are not just lower case letter
        // s.charAt(i) - 'a' cannot be used
        // use the char's int value directly
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        String[] freqToString = new String[s.length() + 1];

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                char c = (char) i;
                StringBuilder sb = new StringBuilder();
                int frequency = freq[i];
                while (freq[i] > 0) {
                    sb.append(c);
                    freq[i]--;
                }
                if (freqToString[frequency] != null) {
                    freqToString[frequency] = sb.append(freqToString[frequency]).toString();
                } else {
                    freqToString[frequency] = sb.toString();
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = freqToString.length - 1; i >= 0; i--) {
            if (freqToString[i] != null) {
                sb.append(freqToString[i]);
            }
        }

        return sb.toString();

    }
}
