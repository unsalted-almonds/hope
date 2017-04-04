package com.shilin.hope.binarysearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. Have you met this
 * question in a real interview? Yes Example Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 * 
 * @author Shilin_Gan
 *
 */
public class Search2DMatrix {

	public static void main(String args[]) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		
		new Search2DMatrix().searchMatrix(matrix, 7);

	}

	/**
	 * @param matrix,
	 *            a list of lists of integers
	 * @param target,
	 *            an integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		// write your code here
		boolean ans = false;

		if (matrix == null || matrix.length == 0) {
			return ans;
		}

		int n = matrix.length;
		int m = matrix[0].length;

		// find a way to translate one dimension index into two dimension index

		int left = 0;
		int right = m * n - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			int row = mid / m;
			int column = mid % m;

			if (matrix[row][column] == target) {
				return true;
			} else if (matrix[row][column] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
			// System.out.println("left = " + left + ", right = " + right);
		}

		return ans;
        
	}

}
