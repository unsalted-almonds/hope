package com.shilin.hope.yama;

import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * <p>
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInStringII {
    public static void main(String[] args) {
        ReverseWordsInStringII test = new ReverseWordsInStringII();

        char[] input = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        test.reverseWords(input);

        System.out.println(Arrays.toString(input));
    }

    // reverse everything, then reverse each word
    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }

        // first reverse everything
        reverse(s, 0, s.length - 1);

        // then reverse each reversed word
        int left = 0, right = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[right] == ' ') {
                reverse(s, left, right - 1);
                left = right + 1;
            }
            right++;
        }

        //handle last one
        reverse(s, left, right - 1);
    }

    private void reverse(char[] s, int left, int right) {

        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
