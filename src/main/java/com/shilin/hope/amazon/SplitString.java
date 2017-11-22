package com.shilin.hope.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitString {

    public static void main(String[] args) {
        SplitString test = new SplitString();

        List<Integer> res = test.solution("ababcbacadefegdehijhklij");

        System.out.println(res);
    }

    public List<Integer> solution(String inputStr) {
        List<Integer> res = new ArrayList<>();
        if (inputStr == null || inputStr.length() == 0) {
            return res;
        }

        int[] letters = new int[26];

        for (int i = 0; i < inputStr.length(); i++) {
            int idx = inputStr.charAt(i) - 'a';
            letters[idx] = letters[idx] + 1;
        }

        Map<Character, Integer> soFar = new HashMap<>();

        int last = -1;
        for (int i = 0; i < inputStr.length(); i++) {
            int idx = inputStr.charAt(i) - 'a';
            letters[idx] = letters[idx] - 1;

            soFar.put(inputStr.charAt(i), letters[idx]);

            if (letters[idx] == 0) {
                soFar.remove(inputStr.charAt(i));
            }

            if (soFar.size() == 0) {
                res.add(i - last);
                last = i;
            }

        }

        return res;
    }
}
