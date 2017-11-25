package com.shilin.hope.amazon;

import java.util.*;

public class KSubstringII {

    public static void main(String[] args) {
        KSubstringII test = new KSubstringII();

        List<String> res = test.solution("WOKAOLEYAMA", 4);

        System.out.println(res);

        res = test.solution2("WOKAOLEYAMA", 4);

        System.out.println(res);
    }

    public List<String> solution(String inputStr, int num) {

        if (inputStr == null || inputStr.length() < num) {
            return new ArrayList<>();
        }

        Map<Character, Integer> seen = new HashMap<>();
        Set<String> resSet = new HashSet<>();

        int end = 0;
        int unique = 0;
        int repeat = 0;

        for (int i = 0; i < inputStr.length() - num + 1; i++) {
            // subtract i - 1 from seen
            if (i > 0) {
                seen.put(inputStr.charAt(i - 1), seen.get(inputStr.charAt(i - 1)) - 1);
                int count = seen.get(inputStr.charAt(i - 1));
                if (count == 0) {
                    seen.remove(inputStr.charAt(i - 1));
                } else if (count == 1) {
                    unique++;
                    repeat--;
                }
            }

            // extend window
            // move end until it has seen enough repeat and unique
            while (repeat < 1 || unique < num - 1) {

                if (end >= inputStr.length()) {
                    return new ArrayList<>(resSet);
                }

                char c = inputStr.charAt(end);
                if (seen.containsKey(c)) {
                    seen.put(c, seen.get(c) + 1);
                    int count = seen.get(c);
                    if (count == 2) {
                        unique--;
                        repeat++;
                    }
                } else {
                    seen.put(c, 1);
                    unique++;
                }
                end++;
            }

            if (end - i == num) {
                resSet.add(inputStr.substring(i, end));
            }

        }

        return new ArrayList<>(resSet);
    }

    // brute force - ish
    public List<String> solution2(String inputStr, int num) {

        if (num > inputStr.length()) {
            return new ArrayList<>();
        }

        Set<String> subStringSet = new HashSet<>();

        for (int i = 0; i < inputStr.length() - num + 1; i++) {
            int start = i;
            int end = i + num - 1;

            if (doContainSolution(start, end, inputStr)) {
                subStringSet.add(inputStr.substring(start, end + 1));
            }

        }

        return new ArrayList<>(subStringSet);
    }

    private boolean doContainSolution(int start, int end, String inputStr) {

        boolean[] letters = new boolean[26];
        int repeatCount = 0;

        for (int i = start; i <= end; i++) {
            char c = inputStr.charAt(i);
            int idx = c - 'A';
            if (letters[idx] && repeatCount > 0) {
                return false;
            }
            if (letters[idx]) {
                repeatCount++;
            }
            letters[idx] = true;
        }
        if (repeatCount == 1) {
            return true;
        }

        return false;

    }
}
