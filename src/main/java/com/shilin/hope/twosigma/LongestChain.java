package com.shilin.hope.twosigma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestChain {

    public static void main(String[] args) {
        LongestChain test = new LongestChain();
        int res = test.logestChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
        System.out.println(res);

        System.out.println("a".substring(0,0));
    }


    public int logestChain(String[] w) {
        int res = 0;
        if (w == null || w.length == 0) {
            return res;
        }

        Set<String> lib = new HashSet<>();
        for (String str : w) {
            lib.add(str);
        }

        Map<String, Integer> record = new HashMap<>();

        for (String str : w) {
            if (str.length() > res) {
                res = Math.max(res, helper(str, lib, record));
            }
        }

        return res;
    }

    private int helper(String str, Set<String> lib, Map<String, Integer> record){
        if (!lib.contains(str)) {
            return 0;
        }

        int res = 1;

        for (int i = 0; i < str.length(); i++) {

            String tmp = str.substring(0, i);
            if (i < str.length() - 1) {
                tmp += str.substring(i + 1);
            }

            if (record.containsKey(tmp)) {
                res = Math.max(res, record.get(tmp) + 1);
                continue;
            }

            int tmpRes = helper(tmp, lib, record);
            res = Math.max(tmpRes + 1, res);
        }
        record.put(str, res);
        return res;
    }

}
