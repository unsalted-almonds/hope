package com.pecan.hope.amazon;

/**
 * 给定两个矩形的左下与右上坐标，求重合面积。 Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * https://leetcode.com/problems/rectangle-area/description/
 */
public class RectangleOverlap {


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // area sum of both
        int res = (C - A) * (D - B) + (G - E) * (H - F);
        // no overlap return
        if (A > G || E > C || B > H || F > D) {
            return res;
        }

        // minus overlap
        return res - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
}
