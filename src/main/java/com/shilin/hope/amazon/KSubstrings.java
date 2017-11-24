package com.shilin.hope.amazon;

import java.util.*;

/**
 *
 */
public class KSubstrings {

    public static void main(String[] args) {
        KSubstrings test = new KSubstrings();
        List<String> res = test.solution("awaglknagawunagwkwagl", 4);

        System.out.println(res);

        res = test.solution2("awaglknagawunagwkwagl", 4);

        System.out.println(res);
    }

    public List<String> solution(String inputStr, int num) {

        if (inputStr == null || num > inputStr.length()) {
            return new ArrayList<>();
        }

        int end = 0;
        Map<Character, Integer> seen = new HashMap<>();
        Set<String> resSet = new HashSet<>();

        for (int i = 0; i < inputStr.length() - num + 1; i++) {

            if (i > 0) {
                if ((seen.get(inputStr.charAt(i - 1)) - 1) == 0) {
                    seen.remove(inputStr.charAt(i - 1));
                } else {
                    seen.put(inputStr.charAt(i - 1), seen.get(inputStr.charAt(i - 1)) - 1);
                }
            }

            while (seen.size() < num) {

                if (end >= inputStr.length()) {
                    return new ArrayList<>(resSet);
                }
                if (seen.containsKey(inputStr.charAt(end))) {
                    seen.put(inputStr.charAt(end), seen.get(inputStr.charAt(end)) + 1);
                } else {
                    seen.put(inputStr.charAt(end), 1);
                }
                end++;
            }

            if (end - i == num) {
                resSet.add(inputStr.substring(i, end));
            }

        }

        return new ArrayList<>(resSet);
    }

    // brute force
    public List<String> solution2(String inputStr, int num) {

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
