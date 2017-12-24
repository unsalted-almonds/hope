package com.shilin.hope.combinatorics;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */

    private static Map<Integer, List<Character>> phoneMap;

    static {
        phoneMap = new HashMap<>();
        phoneMap.put(2, Arrays.asList('a', 'b', 'c'));
        phoneMap.put(3, Arrays.asList('d', 'e', 'f'));
        phoneMap.put(4, Arrays.asList('g', 'h', 'i'));
        phoneMap.put(5, Arrays.asList('j', 'k', 'l'));
        phoneMap.put(6, Arrays.asList('m', 'n', 'o'));
        phoneMap.put(7, Arrays.asList('p', 'q', 'r', 's'));
        phoneMap.put(8, Arrays.asList('t', 'u', 'v'));
        phoneMap.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        helper(digits, result, "", 0);
        return result;
    }

    // this is not necessary to apply the "common" dfs template
    // this is not a good solution
    // refer com.shilin.hope.yama
    private void helper(String digits, List<String> result, String solution, int start) {
        if (solution.length() == digits.length()) {
            result.add(solution);
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            // note: Integer.valueOf(digits.charAt(i)) doesn't work
            // this only works for String
            for (Character c : phoneMap.get(Character.getNumericValue(digits.charAt(i)))) {
                solution = solution + c;
                helper(digits, result, solution, i + 1);
                solution = solution.substring(0, solution.length() - 1);
            }
        }
    }
}
