package com.shilin.hope.yama;

import java.util.*;

public class PhoneLetterCombination {

    static Map<Integer, List<Character>> mapping = new HashMap<>();

    static {
        mapping.put(2, Arrays.asList('a', 'b', 'c'));
        mapping.put(3, Arrays.asList('d', 'e', 'f'));
        mapping.put(4, Arrays.asList('g', 'h', 'i'));
        mapping.put(5, Arrays.asList('j', 'k', 'l'));
        mapping.put(6, Arrays.asList('m', 'n', 'o'));
        mapping.put(7, Arrays.asList('p', 'q', 'r', 's'));
        mapping.put(8, Arrays.asList('t', 'u', 'v'));
        mapping.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        PhoneLetterCombination test = new PhoneLetterCombination();

        List<String> res = test.letterCombinations("2#3");

        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        combinations(digits, "", res);

        return res;

    }

    private void combinations(String digits, String combo, List<String> res) {

        List<Character> letters = mapping.get(digits.charAt(0) - '0');

        if (letters == null) {
            if (digits.length() > 1) {
                combinations(digits.substring(1), combo, res);
            } else {
                res.add(combo);
            }
            return;
        }

        for (Character c : letters) {
            if (digits.length() > 1) {
                combinations(digits.substring(1), combo + c, res);
            } else {
                res.add(combo + c);
            }
        }

    }
}
