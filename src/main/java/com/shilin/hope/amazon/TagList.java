package com.shilin.hope.amazon;


import java.util.*;

public class TagList {

    public static void main(String args[]) {
        TagList test = new TagList();

        List<Integer> res = test.solution(Arrays.asList("made", "in", "spain"), Arrays.asList("made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"));

        System.out.println(res);

        res = test.solution(Arrays.asList("2abc", "bcd", "cab"), Arrays.asList("dbc", "2abc", "cab", "bcd", "bcb"));

        System.out.println(res);

        res = test.solution(Arrays.asList("in", "the", "spain"), Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"));

        System.out.println(res);
    }

    public List<Integer> solution(List<String> targetList, List<String> availableTagList) {

        // put all target into set
        Set<String> target = new HashSet<>(targetList);

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < availableTagList.size() - targetList.size() + 1; i++) {
            int startTmp = i;
            int endTmp;

            if (!target.contains(availableTagList.get(i))) {
                continue;
            }
            // contains target
            target.remove(availableTagList.get(i));

            int j = i + 1;
            while (!target.isEmpty() && j < availableTagList.size()) {
                if (target.contains(availableTagList.get(j))) {
                    target.remove(availableTagList.get(j));
                }
                j++;
            }

            if (target.isEmpty()) {
                endTmp = --j;
                if (len > endTmp - startTmp) {
                    start = startTmp;
                    end = endTmp;
                }
                len = Math.min(len, endTmp - startTmp);
            }

            target = new HashSet<>(targetList);
        }

        if (len < Integer.MAX_VALUE) {
            return Arrays.asList(start, end);
        }

        return Arrays.asList(0);
    }

}
