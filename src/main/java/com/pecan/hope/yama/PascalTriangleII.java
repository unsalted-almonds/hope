package com.pecan.hope.yama;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3, Return [1,3,3,1].
 * <p>
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();

        if (rowIndex < 0) {
            return res;
        }

        res.add(1);
        int row = 1;

        while (row <= rowIndex) {
            // heading 1 is already in place
            for (int i = res.size() - 1; i > 0; i--) {
                res.set(i, res.get(i) + res.get(i - 1));
            }

            // add trailing 1
            res.add(1);

            row++;
        }

        return res;
    }
}
