package com.pecan.hope.yama;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {
    int capacity;
    Partition head, tail;
    Map<Integer, Partition> lookup;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new Partition(0, 0);
        tail = new Partition(0, 0);
        head.next = tail;
        tail.prev = head;
        lookup = new HashMap<>();
    }

    public static void printCache(Partition head, Partition tail) {
        while (head != tail) {
            System.out.println("freq = " + head.freq + ", content = " + head.toString());
            head = head.next;
        }
    }

    public static void main(String[] args) {
        /**
         * ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
         [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
         */

        LFUCache test = new LFUCache(2);
//        test.put(1,1);
//        test.put(2,2);
//        System.out.println(test.get(1));
//        test.put(3,3);
//        System.out.println(test.get(2));
//        System.out.println(test.get(3));
//        test.put(4,4);
//        System.out.println(test.get(1));

        /**
         * ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
         [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
         */
        String[] operation = new String[]{"LFUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        int[][] values = new int[][]{new int[]{10}, new int[]{10, 13}, new int[]{3, 17}, new int[]{6, 11}, new int[]{10, 5}, new int[]{9, 10}, new int[]{13}, new int[]{2, 19}, new int[]{2}, new int[]{3}, new int[]{5, 25}, new int[]{8}, new int[]{9, 22}, new int[]{5, 5}, new int[]{1, 30}, new int[]{11}, new int[]{9, 12}, new int[]{7}, new int[]{5}, new int[]{8}, new int[]{9}, new int[]{4, 30}, new int[]{9, 3}, new int[]{9}, new int[]{10}, new int[]{10}, new int[]{6, 14}, new int[]{3, 1}, new int[]{3}, new int[]{10, 11}, new int[]{8}, new int[]{2, 14}, new int[]{1}, new int[]{5}, new int[]{4}, new int[]{11, 4}, new int[]{12, 24}, new int[]{5, 18}, new int[]{13}, new int[]{7, 23}, new int[]{8}, new int[]{12}, new int[]{3, 27}, new int[]{2, 12}, new int[]{5}, new int[]{2, 9}, new int[]{13, 4}, new int[]{8, 18}, new int[]{1, 7}, new int[]{6}, new int[]{9, 29}, new int[]{8, 21}, new int[]{5}, new int[]{6, 30}, new int[]{1, 12}, new int[]{10}, new int[]{4, 15}, new int[]{7, 22}, new int[]{11, 26}, new int[]{8, 17}, new int[]{9, 29}, new int[]{5}, new int[]{3, 4}, new int[]{11, 30}, new int[]{12}, new int[]{4, 29}, new int[]{3}, new int[]{9}, new int[]{6}, new int[]{3, 4}, new int[]{1}, new int[]{10}, new int[]{3, 29}, new int[]{10, 28}, new int[]{1, 20}, new int[]{11, 13}, new int[]{3}, new int[]{3, 12}, new int[]{3, 8}, new int[]{10, 9}, new int[]{3, 26}, new int[]{8}, new int[]{7}, new int[]{5}, new int[]{13, 17}, new int[]{2, 27}, new int[]{11, 15}, new int[]{12}, new int[]{9, 19}, new int[]{2, 15}, new int[]{3, 16}, new int[]{1}, new int[]{12, 17}, new int[]{9, 1}, new int[]{6, 19}, new int[]{4}, new int[]{5}, new int[]{5}, new int[]{8, 1}, new int[]{11, 7}, new int[]{5, 2}, new int[]{9, 28}, new int[]{1}, new int[]{2, 2}, new int[]{7, 4}, new int[]{4, 22}, new int[]{7, 24}, new int[]{9, 26}, new int[]{13, 28}, new int[]{11, 26}};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (operation[i].equals("put")) {
                sb.append("test.put(" + values[i][0] + ", " + values[i][1] + "); \n");
                sb.append("printCache(test.head, test.tail);\n");
            } else if (operation[i].equals("get")) {
                sb.append("test.get(" + values[i][0] + "); \n");
                sb.append("printCache(test.head, test.tail);\n");
            }

        }

        //System.out.println(sb);
        test = new LFUCache(10);

        test.put(10, 13);
        printCache(test.head, test.tail);
        test.put(3, 17);
        printCache(test.head, test.tail);
        test.put(6, 11);
        printCache(test.head, test.tail);
        test.put(10, 5);
        printCache(test.head, test.tail);
        test.put(9, 10);
        printCache(test.head, test.tail);
        test.get(13);
        printCache(test.head, test.tail);
        test.put(2, 19);
        printCache(test.head, test.tail);
        test.get(2);
        printCache(test.head, test.tail);
        test.get(3);
        printCache(test.head, test.tail);
        test.put(5, 25);
        printCache(test.head, test.tail);
        test.get(8);
        printCache(test.head, test.tail);
        test.put(9, 22);
        printCache(test.head, test.tail);
        test.put(5, 5);
        printCache(test.head, test.tail);
        test.put(1, 30);
        printCache(test.head, test.tail);
        test.get(11);
        printCache(test.head, test.tail);
        test.put(9, 12);
        printCache(test.head, test.tail);
        test.get(7);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.get(8);
        printCache(test.head, test.tail);
        test.get(9);
        printCache(test.head, test.tail);
        test.put(4, 30);
        printCache(test.head, test.tail);
        test.put(9, 3);
        printCache(test.head, test.tail);
        test.get(9);
        printCache(test.head, test.tail);
        test.get(10);
        printCache(test.head, test.tail);
        test.get(10);
        printCache(test.head, test.tail);
        test.put(6, 14);
        printCache(test.head, test.tail);
        test.put(3, 1);
        printCache(test.head, test.tail);
        test.get(3);
        printCache(test.head, test.tail);
        test.put(10, 11);
        printCache(test.head, test.tail);
        test.get(8);
        printCache(test.head, test.tail);
        test.put(2, 14);
        printCache(test.head, test.tail);
        test.get(1);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.get(4);
        printCache(test.head, test.tail);
        test.put(11, 4);
        printCache(test.head, test.tail);
        test.put(12, 24);
        printCache(test.head, test.tail);
        test.put(5, 18);
        printCache(test.head, test.tail);
        test.get(13);
        printCache(test.head, test.tail);
        test.put(7, 23);
        printCache(test.head, test.tail);
        test.get(8);
        printCache(test.head, test.tail);
        test.get(12);
        printCache(test.head, test.tail);
        test.put(3, 27);
        printCache(test.head, test.tail);
        test.put(2, 12);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.put(2, 9);
        printCache(test.head, test.tail);
        test.put(13, 4);
        printCache(test.head, test.tail);
        test.put(8, 18);
        printCache(test.head, test.tail);
        test.put(1, 7);
        printCache(test.head, test.tail);
        test.get(6);
        printCache(test.head, test.tail);
        test.put(9, 29);
        printCache(test.head, test.tail);
        test.put(8, 21);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.put(6, 30);
        printCache(test.head, test.tail);
        test.put(1, 12);
        printCache(test.head, test.tail);
        test.get(10);
        printCache(test.head, test.tail);
        test.put(4, 15);
        printCache(test.head, test.tail);
        test.put(7, 22);
        printCache(test.head, test.tail);
        test.put(11, 26);
        printCache(test.head, test.tail);
        test.put(8, 17);
        printCache(test.head, test.tail);
        test.put(9, 29);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.put(3, 4);
        printCache(test.head, test.tail);
        test.put(11, 30);
        printCache(test.head, test.tail);
        test.get(12);
        printCache(test.head, test.tail);
        test.put(4, 29);
        printCache(test.head, test.tail);
        test.get(3);
        printCache(test.head, test.tail);
        test.get(9);
        printCache(test.head, test.tail);
        test.get(6);
        printCache(test.head, test.tail);
        test.put(3, 4);
        printCache(test.head, test.tail);
        test.get(1);
        printCache(test.head, test.tail);
        test.get(10);
        printCache(test.head, test.tail);
        test.put(3, 29);
        printCache(test.head, test.tail);
        test.put(10, 28);
        printCache(test.head, test.tail);
        test.put(1, 20);
        printCache(test.head, test.tail);
        test.put(11, 13);
        printCache(test.head, test.tail);
        test.get(3);
        printCache(test.head, test.tail);
        test.put(3, 12);
        printCache(test.head, test.tail);
        test.put(3, 8);
        printCache(test.head, test.tail);
        test.put(10, 9);
        printCache(test.head, test.tail);
        test.put(3, 26);
        printCache(test.head, test.tail);
        test.get(8);
        printCache(test.head, test.tail);
        test.get(7);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.put(13, 17);
        printCache(test.head, test.tail);
        test.put(2, 27);
        printCache(test.head, test.tail);
        test.put(11, 15);
        printCache(test.head, test.tail);
        test.get(12);
        printCache(test.head, test.tail);
        test.put(9, 19);
        printCache(test.head, test.tail);
        test.put(2, 15);
        printCache(test.head, test.tail);
        test.put(3, 16);
        printCache(test.head, test.tail);
        test.get(1);
        printCache(test.head, test.tail);
        test.put(12, 17);
        printCache(test.head, test.tail);
        test.put(9, 1);
        printCache(test.head, test.tail);
        test.put(6, 19);
        printCache(test.head, test.tail);
        test.get(4);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.get(5);
        printCache(test.head, test.tail);
        test.put(8, 1);
        printCache(test.head, test.tail);
        test.put(11, 7);
        printCache(test.head, test.tail);
        test.put(5, 2);
        printCache(test.head, test.tail);
        test.put(9, 28);
        printCache(test.head, test.tail);
        test.get(1);
        printCache(test.head, test.tail);
        test.put(2, 2);
        printCache(test.head, test.tail);
        test.put(7, 4);
        printCache(test.head, test.tail);
        test.put(4, 22);
        printCache(test.head, test.tail);
        test.put(7, 24);
        printCache(test.head, test.tail);
        test.put(9, 26);
        printCache(test.head, test.tail);
        test.put(13, 28);
        printCache(test.head, test.tail);
        test.put(11, 26);
        printCache(test.head, test.tail);

    }

    public int get(int key) {
        if (!lookup.containsKey(key)) {
            System.out.println("get " + key + " = " + (-1));
            return -1;
        }
        Partition currentPartition = lookup.get(key);
        int res = currentPartition.get(key);
        moveToNextPartition(key, res);
        System.out.println("get " + key + " = " + res);
        return res;
    }

    public void put(int key, int value) {
        // forbid any further action
        if (capacity == 0) return;

        // when key already there
        if (lookup.containsKey(key)) {
            moveToNextPartition(key, value);
            System.out.println("put " + key + " = " + value);
            return;
        }
        // when key is new
        // insert into first partition?
        // check if capacity reached
        if (lookup.size() == capacity) {
            // remove least frequently and least recently used
            removeLFUAndLRU();
        }
        // check freq of the first partition
        // if key is only been inserted once, the freq is 1
        addFirstPartition(key, value);
        System.out.println("put " + key + " = " + value);
    }

    private void addFirstPartition(int key, int value) {
        Partition currentFirst = head.next;
        int currentFirstFreq = head.next.freq;
        // create new partition
        if (currentFirstFreq > 1 || currentFirst == tail) {
            Partition newFirst = new Partition(capacity, 1);
            newFirst.put(key, value);
            head.next = newFirst;
            newFirst.prev = head;
            newFirst.next = currentFirst;
            currentFirst.prev = newFirst;
            lookup.put(key, newFirst);
        }
        // use first partition
        else {
            currentFirst.put(key, value);
            lookup.put(key, currentFirst);
        }
    }

    private void removeLFUAndLRU() {
        Partition first = head.next;
        Iterator<Map.Entry<Integer, Integer>> it = first.entrySet().iterator();
        Map.Entry<Integer, Integer> firstEntry = it.next();
        first.remove(firstEntry.getKey());
        lookup.remove(firstEntry.getKey());
        if (first.isEmpty()) {
            removePartition(first);
        }
        System.out.println("removed " + firstEntry);
    }

    // once key is accessed, move to next partition
    private void moveToNextPartition(int key, int value) {
        // remove from current partition
        Partition current = lookup.get(key);
        current.remove(key);
        // move to the end of next partition
        // this is taken care of by linked hash map
        Partition next = current.next;

        if (next.freq == current.freq + 1) {
            next.put(key, value);
            lookup.put(key, next);
        } else {
            Partition newPartition = new Partition(capacity, current.freq + 1);
            newPartition.put(key, value);
            current.next = newPartition;
            newPartition.prev = current;
            newPartition.next = next;
            next.prev = newPartition;
            lookup.put(key, newPartition);
        }

        if (current.isEmpty()) removePartition(current);
    }

    private void removePartition(Partition p) {
        if (p.size() > 0) return;
        Partition prev = p.prev;
        Partition next = p.next;
        prev.next = next;
        next.prev = prev;
    }

    static class Partition extends LinkedHashMap<Integer, Integer> {
        Partition prev, next;
        int freq;

        // for LinkedHashMap with accessing order, least accessed is at the head
        public Partition(int capacity, int freq) {
            super(capacity + 1, .75f, true);
            this.freq = freq;
        }

//        @Override
//        public String toString() {
//            return "Partition{" +
//                    "freq=" + freq +
//                    '}';
//        }
    }

}
