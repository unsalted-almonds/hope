package com.shilin.hope.amazon;


import java.util.*;

public class TagList {

    public static void main(String args[]) {
        TagList test = new TagList();

        List<Integer> res = test.solution(Arrays.asList("made", "in", "spain"), Arrays.asList("made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"));

        System.out.println(res);

        res = test.solution3(Arrays.asList("made", "in", "spain"), Arrays.asList("made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"));

        System.out.println(res);


        res = test.solution(Arrays.asList("2abc", "bcd", "cab"), Arrays.asList("dbc", "2abc", "cab", "bcd", "bcb"));

        System.out.println(res);

        res = test.solution(Arrays.asList("in", "the", "spain"), Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"));

        System.out.println(res);

        res = test.solution3(Arrays.asList("in", "the", "spain"), Arrays.asList("the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"));

        System.out.println(res);
    }

    public List<Integer> solution3(List<String> targetList, List<String> availableTagList) {

        List<Integer> res = new ArrayList<>();

        if (targetList == null || availableTagList == null || targetList.size() > availableTagList.size()) {
            return res;
        }

        int len = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int start = Integer.MIN_VALUE;
        int tmpEnd = 0;
        int tmpStart = 0;

        Map<String, Integer> seen = new HashMap<>();
        Set<String> targetSet = new HashSet<>(targetList);

        for (int i = 0; i < availableTagList.size(); i++) {
            if (i > 0) {
                String last = availableTagList.get(i - 1);
                if (seen.containsKey(last)) {
                    seen.put(last, seen.get(last) - 1);
                    if (seen.get(last) == 0) {
                        seen.remove(last);
                    }
                }
            }

            // extend end
            while (seen.size() != targetSet.size()) {
                if (tmpEnd == availableTagList.size()) {
                    if (start == Integer.MIN_VALUE || end == Integer.MIN_VALUE) {
                        return Arrays.asList(0);
                    }
                    return Arrays.asList(start, end);
                }
                String str = availableTagList.get(tmpEnd);
                if (targetSet.contains(str)) {
                    if (seen.containsKey(str)) {
                        seen.put(str, seen.get(str) + 1);
                    } else {
                        seen.put(str, 1);
                    }
                }
                tmpEnd++;
            }

            if (tmpEnd - i < len) {
                len = tmpEnd - i;
                start = i;
                end = tmpEnd - 1;
            }

        }

        return Arrays.asList(start, end);
    }


    // target list doesn't contain duplicate tags
    // this solution seems to be wrong!
    public List<Integer> solution(List<String> targetList, List<String> availableTagList) {

        if (targetList == null || availableTagList == null || targetList.size() == 0 || availableTagList.size() == 0 || targetList.size() > availableTagList.size()) {
            return Arrays.asList(0);
        }

        // construct first window
        int start = 0;
        int end = 0;

        Set<String> targetSet = new HashSet<>(targetList);
        Set<String> bookKeeping = new HashSet<>(targetList);
        // target tag count within a window
        Map<String, Integer> windowCount = new HashMap<>();

        for (int i = 0; i < availableTagList.size(); i++) {

            String tag = availableTagList.get(i);
            if (targetSet.contains(tag)) {
                // finding the starting index
                if (targetList.size() == bookKeeping.size()) {
                    start = i;
                }
                bookKeeping.remove(tag);
                if (bookKeeping.isEmpty()) {
                    end = i;
                }

                // record its count in map
                if (windowCount.containsKey(tag)) {
                    windowCount.put(tag, windowCount.get(tag) + 1);
                } else {
                    windowCount.put(tag, 1);
                }
            }
        }

        // unable to find a match
        if (!bookKeeping.isEmpty()) {
            return Arrays.asList(0);
        }

        // if there's only one tag, then the solution has been found
        if (end == start) {
            return Arrays.asList(start, end);
        }

        int len = end - start + 1;

        int tmpStart = start;
        int tmpEnd = end;

        // use first window to keep searching
        while (tmpEnd < availableTagList.size()) {

            String startTag = availableTagList.get(tmpStart);
            // move start forward
            windowCount.put(startTag, windowCount.get(startTag) - 1);
            tmpStart++;

            // move forward start
            for (int i = tmpStart; i < tmpEnd; i++) {
                if (windowCount.containsKey(availableTagList.get(i))) {
                    int tmp = windowCount.get(availableTagList.get(i)) - 1;
                    if (tmp == 0) {
                        tmpStart = i;
                        break;
                    } else {
                        windowCount.put(availableTagList.get(i), tmp);
                    }
                }
            }
            if (windowCount.get(startTag) == 0) {
                // move forward end
                while (tmpEnd < availableTagList.size() && !availableTagList.get(tmpStart).equals(startTag)) {
                    tmpEnd++;
                }
                // doesn't find return
                if (tmpEnd == availableTagList.size()) {
                    return Arrays.asList(start, end);
                } else {
                    windowCount.put(startTag, 1);
                }
            }

            if (len > tmpEnd - tmpStart + 1) {
                len = tmpEnd - tmpStart + 1;
                start = tmpStart;
                end = tmpEnd;
            }
        }


        return Arrays.asList(start, end);
    }


    // this is a brute force way
    public List<Integer> solution2(List<String> targetList, List<String> availableTagList) {

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
