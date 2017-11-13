package com.shilin.hope.amazon;

import java.util.*;

/**
 * Item Association (LC 547) 给了一些 itemAssociation, 如果一个 item 既在 association A 里面出现过， 又在 association B 里面出现过，那么就把 A 和 B
 * 合并成一个 association。求全部合 并后最大的 association。 如果两个 association 一样大，返回 lexicographic order 的第一个。 input:String[][]
 * itemAssociation return: String[]. example: input: [itemA, itemB] [itemB, itemC] [itemD, itemE]. 合并之后: [itemA, itemB,
 * itemC] [itemD, itemE] 第一个有三个 item 最多，于是返回[itemA, itemB, itemC]
 * <p>
 * <p>
 * quick union: https://neo1218.github.io/unionfind/
 */
public class ItemAssociation {

    public static void main(String[] args) {

        String[][] input = {{"itemA", "itemB"}, {"itemB", "itemC"}, {"itemD", "itemE"}};

        new ItemAssociation().solution(input);

        input = new String[][]{{"g", "b"}, {"a", "b"}, {"b", "d"}, {"c", "e"}, {"f", "c"}, {"f", "h"}, {"i", "j"}, {"j", "k"}};
        new ItemAssociation().solution(input);

    }

    public String[] solution(String[][] input) {

        Map<String, String> parent = new HashMap<>();

        for (String[] association : input) {
            for (String item : association) {
                parent.put(item, item);
            }
        }

        for (String[] association : input) {
            int i = 0;
            int j = 1;
            while (j < association.length) {
                union(parent, association[i], association[j]);
                i++;
                j++;
            }
        }

        Map<String, List<String>> rootChildren = new HashMap<>();

        int size = 0;
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : parent.entrySet()) {
            String root = root(parent, entry.getKey());
            if (rootChildren.containsKey(root)) {
                List<String> children = rootChildren.get(root);
                children.add(entry.getKey());
            } else {
                rootChildren.put(root, new ArrayList<>(Arrays.asList(entry.getKey())));
            }
            if (rootChildren.get(root).size() > size) {
                size = rootChildren.get(root).size();
                result = new ArrayList<>(Arrays.asList(root));
            } else if (rootChildren.get(root).size() == size) {
                result.add(root);
            }
        }


        if (result.size() == 1) {
            return result.toArray(new String[rootChildren.get(result.get(0)).size()]);
        }

        String[] finalResult = null;
        String smallest = null;
        for (String root : result) {
            System.out.println(rootChildren.get(root));
            List<String> resultset = rootChildren.get(root);
            Collections.sort(resultset);
            if (smallest == null || (resultset.get(0).compareTo(smallest) < 0)) {
                smallest = resultset.get(0);
                finalResult = resultset.toArray(new String[resultset.size()]);
            }
        }

        System.out.println(Arrays.toString(finalResult));
        return finalResult;
    }

    private void union(Map<String, String> parent, String item1, String item2) {
        parent.put(root(parent, item1), root(parent, item2));
    }


    private String root(Map<String, String> parent, String item) {
        while (!parent.get(item).equals(item)) {
            item = parent.get(item);
        }
        return item;
    }

    private boolean isConnected(Map<String, String> parent, String item1, String item2) {
        return root(parent, item1).equals(root(parent, item2));
    }
}
