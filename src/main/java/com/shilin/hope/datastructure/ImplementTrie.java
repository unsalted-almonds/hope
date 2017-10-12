package com.shilin.hope.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */


class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    char val;
    boolean hasWord;

    public TrieNode(char c) {
        this.val = c;
        children = new HashMap<Character, TrieNode>();
    }

    public void insert(char c) {
        if (!children.containsKey(c)) {
            TrieNode node = new TrieNode(c);
            children.put(c, node);
        }
    }

    public boolean isChild(char c) {
        return children.containsKey(c);
    }

    public TrieNode getChild(char c) {
        if (isChild(c)) {
            return children.get(c);
        }
        return null;
    }
}

public class ImplementTrie {


    private TrieNode root;

    public ImplementTrie() {
        // do intialization if necessary
        root = new TrieNode(Character.MIN_VALUE);
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            parent.insert(word.charAt(i));
            parent = parent.getChild(word.charAt(i));
        }
        parent.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            if (!parent.isChild(word.charAt(i))) {
                return false;
            }
            parent = parent.getChild(word.charAt(i));
        }
        return parent.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode parent = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!parent.isChild(prefix.charAt(i))) {
                return false;
            }
            parent = parent.getChild(prefix.charAt(i));
        }
        return true;
    }
}