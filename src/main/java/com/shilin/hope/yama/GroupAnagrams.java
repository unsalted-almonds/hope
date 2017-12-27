package com.shilin.hope.yama;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * <p>
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> codecMap = new HashMap<>();

        for (String str : strs) {
            String encoded = encode(str);
            if (codecMap.containsKey(encoded)) {
                codecMap.get(encoded).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                codecMap.put(encoded, l);
            }
        }

        for (String key : codecMap.keySet()) {
            res.add(codecMap.get(key));
        }

        return res;

    }

    private String encode(String str) {
        int[] codec = new int[26];

        for (int i = 0; i < str.length(); i++) {
            codec[str.charAt(i) - 'a']++;
        }

        return Arrays.toString(codec);
    }
}
