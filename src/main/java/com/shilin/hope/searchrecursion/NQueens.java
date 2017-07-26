package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	
	public static void main(String[] args){
		
		System.out.println(new NQueens().solveNQueens(2));
	}
	
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        if (n <= 0) {
            return result;    
        }
        
        boolean[][] placement = new boolean[n][n];
        
        helper(result, 0, 0, placement);
        
        return result;
        
    }
    
    private void helper(ArrayList<ArrayList<String>> result, int row, int column, boolean[][] placement) {
        // every row has been explored
        if (row == placement.length) {
            ArrayList<String> solution = new ArrayList<String>(placement.length);
            for (int i = 0; i < placement.length; i++) {
                StringBuffer sb = new StringBuffer();
                for (boolean bol : placement[i]) {
                    sb.append(bol ? "Q":".");
                }
                solution.add(sb.toString());
            }
            result.add(solution);
            return;
        }
        
        for (int i = row; i < placement.length; i++) {
            for (int j = column; j < placement[0].length; j++) {
                if (isSafe(i, j, placement)) {
                    placement[i][j] = true;
                    int newRow = i + 1;
                    helper(result, newRow, 0, placement);
                    placement[i][j] = false;
                }
            }

            for (boolean bol : placement[i]) {
                if (bol){
                    continue;
                }
            }
            break;
        }
    }
    
    private boolean isSafe(int row, int column, boolean[][] placement) {
        // check row 
        for (boolean bol : placement[row]) {
            if (bol == true) {
                return false;
            }
        }
        // check column
        for (int i = 0; i < placement.length; i++){
            if (placement[i][column] == true) {
                return false;
            }
        }
        
        // check left diag 
        int i = row;
        int j = column;
        while (i > 0 && j > 0) {
            if (placement[--i][--j] == true) {
                return false;
            }
        }
        
        i = row;
        j = column;
        while (i > 0 && j < placement[0].length - 1) {
            if (placement[--i][++j] == true) {
                return false;
            }
        }
        
        i = row;
        j = column;
        while (i < placement.length - 1 && j > 0) {
            if (placement[++i][--j] == true) {
                return false;
            }
        }
        
        i = row;
        j = column;
        while (i < placement.length - 1 && j < placement[0].length - 1) {
            if (placement[++i][++j] == true) {
                return false;
            }
        }
        
        return true;
    }
}
