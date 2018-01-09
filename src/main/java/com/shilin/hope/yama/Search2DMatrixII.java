package com.shilin.hope.yama;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right. Integers in each column are sorted in ascending from
 * top to bottom. For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [ [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30] ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // start from bottom left
        int column = 0, row = matrix.length - 1;

        while (column < matrix[0].length && row >= 0) {
            int current = matrix[row][column];
            if (current == target) {
                return true;
            }

            if (current < target) {
                column++;
            } else {
                row--;
            }
        }

        return false;
    }
}
