package com.pecan.hope.yama;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item. Created by Shilin_Gan on 11/28/2017.
 */
public class LRUCache {

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {
        // do intialization if necessar
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.after = tail;
        tail.before = head;
        cache = new HashMap<>();
    }

    public static void main(String args[]) {
        LRUCache test = new LRUCache(2);
        test.set(2, 1);
        System.out.println("first " + test.head.after.key);
        System.out.println("last " + test.tail.before.key);
        test.set(1, 1);
        System.out.println("first " + test.head.after.key);
        System.out.println("last " + test.tail.before.key);
        System.out.println(test.get(2));
        System.out.println("first " + test.head.after.key);
        System.out.println("last " + test.tail.before.key);
        test.set(4, 1);
        System.out.println("first " + test.head.after.key);
        System.out.println("last " + test.tail.before.key);
        System.out.println(test.get(1));
        System.out.println("first " + test.head.after.key);
        System.out.println("last " + test.tail.before.key);

    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (cache.containsKey(key)) {
            Node tmp = cache.get(key);
            removeNode(tmp.key);
            addToTail(tmp.key, tmp.val);
            return tmp.val;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            removeNode(key);
        }

        addToTail(key, value);

        if (cache.size() > capacity) {
            poll();
        }

        return;
    }

    private void removeNode(int key) {
        Node remove = cache.get(key);
        Node before = remove.before;
        Node after = remove.after;
        before.after = after;
        after.before = before;
        cache.remove(key);
    }

    private void addToTail(int key, int val) {
        Node oldLast = tail.before;
        Node newLast = new Node(key, val);
        oldLast.after = newLast;
        newLast.after = tail;
        newLast.before = oldLast;
        tail.before = newLast;
        cache.put(key, newLast);
        System.out.println("moved to tail " + key);
    }

    private void poll() {
        Node first = head.after;
        removeNode(first.key);
    }

    private static class Node {

        int key, val;
        Node before, after;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
