package com.shilin.hope.combinatorics;

import java.util.HashMap;
import java.util.Map;

public class StringPermutations {
    /*
 * @param A: a string
 * @param B: a string
 * @return: a boolean
 */
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }

        Map<Character, Integer> record = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (record.containsKey(c)) {
                record.put(c, record.get(c) + 1);
            } else {
                record.put(c, 1);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if (!record.containsKey(c)) {
                return false;
            }
            record.put(c, record.get(c) - 1);
            if (record.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}
