package com.shilin.hope.yama;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word
 * with the lower alphabetical order comes first.
 * <p>
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 Output: ["i", "love"] Explanation: "i" and
 * "love" are the two most frequent words. Note that "i" comes before "love" due to a lower alphabetical order. Example
 * 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4 Output: ["the", "is",
 * "sunny", "day"] Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively. Note: You may assume k is always valid, 1 ≤ k ≤ number of unique
 * elements. Input words contain only lowercase letters. Follow up: Try to solve it in O(n log k) time and O(n) extra
 * space.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();

        if (words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> count = new HashMap<>();

        for (String str : words) {
            if (count.containsKey(str)) {
                count.put(str, count.get(str) + 1);
            } else {
                count.put(str, 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>(new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                if (w1.freq.compareTo(w2.freq) == 0) {
                    return w2.val.compareTo(w1.val);
                }
                return w1.freq.compareTo(w2.freq);
            }
        });

        for (String key : count.keySet()) {
            Word current = new Word(count.get(key), key);
            pq.offer(current);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(0, pq.poll().val);
        }

        return res;
    }

    private static class Word {
        Integer freq;
        String val;

        public Word(Integer freq, String val) {
            this.freq = freq;
            this.val = val;
        }
    }
}
