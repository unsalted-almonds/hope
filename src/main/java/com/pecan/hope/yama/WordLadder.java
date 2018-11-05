package com.pecan.hope.yama;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time. Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word. For example,
 * <p>
 * Given: beginWord = "hit" endWord = "cog" wordList = ["hot","dot","dog","lot","log","cog"] As one shortest
 * transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * <p>
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All words contain only
 * lowercase alphabetic characters. You may assume no duplicates in the word list. You may assume beginWord and endWord
 * are non-empty and are not the same. UPDATE (2017/1/20): The wordList parameter had been changed to a list of strings
 * (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class WordLadder {
    // the solution requires end word must be in word list

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            return 0;
        }

        Queue<String> bfs = new LinkedList<>();
        bfs.offer(beginWord);
        int depth = 1;
        boolean[] visited = new boolean[wordList.size()];

        while (!bfs.isEmpty()) {
            Queue<String> level = new LinkedList<>();
            depth++;
            while (!bfs.isEmpty()) {
                String word = bfs.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (!visited[i] && diffByOne(word, wordList.get(i))) {
                        if (wordList.get(i).equals(endWord)) {
                            return depth;
                        }
                        level.offer(wordList.get(i));
                        visited[i] = true;
                    }
                }
            }
            bfs = level;
        }

        return 0;
    }


    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()) {
            return 0;
        }

        int res = helper(beginWord, endWord, wordList, new boolean[wordList.size()], 1);

        return (res == Integer.MAX_VALUE) ? 0 : res;

    }

    // dfs will time out
    // dfs goes into every path while bfs will stop once solution find
    private int helper(String beginWord, String endWord, List<String> wordList, boolean[] visited, int step) {
        if (beginWord.equals(endWord)) {
            return step;
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < wordList.size(); i++) {
            String path = wordList.get(i);
            if (!visited[i] && diffByOne(beginWord, path)) {
                visited[i] = true;
                res = Math.min(res, helper(path, endWord, wordList, visited, step + 1));
                visited[i] = false;
            }
        }

        return res;
    }

    private boolean diffByOne(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int diff = 0;
        for (int i = 0; i < charA.length; i++) {
            if (charA[i] != charB[i])
                diff++;
        }

        return diff == 1;
    }
}
