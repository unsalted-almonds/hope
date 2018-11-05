package com.pecan.hope.yama;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up: Did you use extra space? A straight forward solution using O(mn) space is probably a bad idea. A simple
 * improvement uses O(m + n) space, but still not the best solution. Could you devise a constant space solution?
 */
public class SetMatrixZeros {

    public static void main(String[] args) {
        SetMatrixZeros test = new SetMatrixZeros();

        int[][] input =
                new int[][]{{3, 5, 5, 6, 9, 1, 4, 5, 0, 5},
                        {2, 7, 9, 5, 9, 5, 4, 9, 6, 8},
                        {6, 0, 7, 8, 1, 0, 1, 6, 8, 1},
                        {7, 2, 6, 5, 8, 5, 6, 5, 0, 6},
                        {2, 3, 3, 1, 0, 4, 6, 5, 3, 5},
                        {5, 9, 7, 3, 8, 8, 5, 1, 4, 3},
                        {2, 4, 7, 9, 9, 8, 4, 7, 3, 7},
                        {3, 5, 2, 8, 8, 2, 2, 4, 9, 8}};

        test.setZeroes(input);
        System.out.println("=================");
        test.printLevel(input);
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        boolean firsRowZero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firsRowZero = true;
                break;
            }
        }

        boolean firstColumnZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // set rows
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set columns
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firsRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    private void printLevel(int[][] input) {
        for (int[] l : input) {
            System.out.println(Arrays.toString(l));
        }
    }
}
