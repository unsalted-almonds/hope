package com.shilin.hope.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class KSubstrings {

    public static void main(String[] args) {
        KSubstrings test = new KSubstrings();
        List<String> res = test.solution("awaglknagawunagwkwagl", 4);

        System.out.println(res);
    }

    public List<String> solution(String inputStr, int num) {

        if (num > inputStr.length()) {
            return new ArrayList<>();
        }

        char[] charArr = inputStr.toCharArray();

        Set<String> subStringSet = new HashSet<>();

        for (int i = 0; i < charArr.length - num + 1; i++) {
            int start = i;
            int end = i + num - 1;

            if (isDistinct(start, end, charArr)) {
                subStringSet.add(inputStr.substring(start, end + 1));
            }
        }

        return new ArrayList<>(subStringSet);
    }

    private boolean isDistinct(int start, int end, char[] input) {
        boolean[] letters = new boolean[26];

        for (int i = start; i <= end; i++) {
            int idx = input[i] - 'a';
            if (letters[idx]) {
                return false;
            }
            letters[idx] = true;
        }

        return true;
    }
}
