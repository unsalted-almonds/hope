package com.shilin.hope.datastructure;

import java.util.*;

/**
 * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 * <p>
 * <p>
 * Have you met this question in a real interview? Yes
 * Example
 * Given matrix:
 * doaf
 * agai
 * dcan
 * and dictionary:
 * {"dog", "dad", "dgdg", "can", "again"}
 * <p>
 * return {"dog", "dad", "can", "again"}
 */
public class WordSearchII {

    /*
 * @param board: A list of lists of character
 * @param words: A list of string
 * @return: A list of string
 */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0 || words == null || words.isEmpty()) {
            return result;
        }

        Map<Character, List<Pair>> charLocations = getLocations(board);

        for (String word : words) {
            if (charLocations.containsKey(word.charAt(0))) {
                List<Pair> locations = charLocations.get(word.charAt(0));
                for (Pair location : locations) {
                    if (searchWordFrom(board, word, location)) {
                        result.add(word);
                        break;
                    }
                }
            }
        }

        return result;

    }

    private boolean searchWordFrom(char[][] board, String word, Pair location) {
        return searchWordFrom(board, word, 0, location, new HashSet<Pair>());
    }

    private boolean searchWordFrom(char[][] board, String word, int ith, Pair location, Set<Pair> visited) {
        if (board[location.x][location.y] == word.charAt(ith) && ith == word.length() - 1) {
            return true;
        }

        if (board[location.x][location.y] != word.charAt(ith)) {
            return false;
        }

        ith++;
        int[] xVector = {-1, 1, 0, 0};
        int[] yVector = {0, 0, -1, 1};
        visited.add(location);
        for (int i = 0; i < 4; i++) {
            int x = location.x + xVector[i];
            int y = location.y + yVector[i];
            Pair visitingPair = new Pair(x, y);

            if (visited.contains(visitingPair)) {
                continue;
            }

            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {

                visited.add(visitingPair);
                if (!searchWordFrom(board, word, ith, visitingPair, visited)) {
                    visited.remove(visitingPair);
                    continue;
                }
                return true;
            }
        }

        return false;

    }

    private Map<Character, List<Pair>> getLocations(char[][] board) {
        Map<Character, List<Pair>> result = new HashMap<Character, List<Pair>>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (result.containsKey(board[i][j])) {
                    result.get(board[i][j]).add(new Pair(i, j));
                    continue;
                }

                result.put(board[i][j], new ArrayList<Pair>(Arrays.asList(new Pair(i, j))));
            }
        }

        return result;
    }

    private class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        ;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair testMy = (Pair) o;

            if (x != testMy.x) return false;
            return y == testMy.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
