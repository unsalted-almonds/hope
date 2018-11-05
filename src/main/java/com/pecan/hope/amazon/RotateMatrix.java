package com.pecan.hope.amazon;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note: You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT
 * allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * <p>
 * rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2], [9,6,3] ] Example 2:
 * <p>
 * Given input matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16] ],
 * <p>
 * rotate the input matrix in-place such that it becomes: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7,10,11]
 * ]
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int start = 0;
        int end = matrix.length - 1;

        while (end > start) {

            for (int i = 0; i < end - start; i++) {
                int tmp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end - i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[start + i][end];
                matrix[start + i][end] = tmp;
            }

            end--;
            start++;
        }
    }
}
