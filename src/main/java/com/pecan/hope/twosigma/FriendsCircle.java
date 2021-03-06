package com.pecan.hope.twosigma;

import java.util.HashMap;
import java.util.Map;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in
 * nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.
 * <p>
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith
 * and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend
 * circles among all the students.
 * <p>
 * Example 1: Input: [[1,1,0], [1,1,0], [0,0,1]] Output: 2 Explanation:The 0th and 1st students are direct friends, so
 * they are in a friend circle. The 2nd student himself is in a friend circle. So return 2. Example 2: Input: [[1,1,0],
 * [1,1,1], [0,1,1]] Output: 1 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are
 * direct friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so
 * return 1. Note: N is in range [1,200]. M[i][i] = 1 for all students. If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendsCircle {
    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0) {
            return 0;
        }

        Map<Integer, Integer> parent = new HashMap<>();
        for (int i = 0; i < M.length; i++) {
            parent.put(i, i);
        }

        // union
        for (int i = 0; i < M.length; i++) {
            int[] tmp = M[i];
            for (int j = 0; j < M[0].length; j++) {
                if (tmp[j] == 0) continue;
                if (find(i, j, parent)) continue;
                union(i, j, parent);
            }
        }

        //Set<Integer> roots = new HashSet<>();
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
            //roots.add(getRoot(entry.getKey(), parent));
            if (entry.getKey() == entry.getValue()) {
                res++;
            }
        }

        return res;

    }

    private boolean find(int m, int n, Map<Integer, Integer> parent) {
        return getRoot(m, parent) == getRoot(n, parent);
    }

    private void union(int m, int n, Map<Integer, Integer> parent) {
        int rootM = getRoot(m, parent);
        int rootN = getRoot(n, parent);
        parent.put(rootM, rootN);
    }

    private int getRoot(int m, Map<Integer, Integer> parent) {
        int child = m;
        int parentTmp = parent.get(m);

        while (child != parentTmp) {
            child = parentTmp;
            parentTmp = parent.get(parentTmp);
        }

        return child;
    }
}
