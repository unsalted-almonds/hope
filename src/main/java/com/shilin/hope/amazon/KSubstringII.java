package com.shilin.hope.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KSubstringII {

    public static void main(String[] args) {
        KSubstringII test = new KSubstringII();

        List<String> res = test.solution("WOKAOLEYAMA", 4);

        System.out.println(res);
    }

    public List<String> solution(String inputStr, int num) {

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
