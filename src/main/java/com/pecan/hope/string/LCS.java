package com.pecan.hope.string;

/**
 * Given two strings, find the longest common substring.
 * 
 * Return the length of it.
 * 
 * Notice
 * 
 * The characters in substring should occur continuously in original string.
 * This is different with subsequence.
 * 
 * Example Given A = "ABCD", B = "CBCE", return 2.
 * 
 * @author Shilin_Gan
 *
 */
public class LCS {
	/**
	 * @param A,
	 *            B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0){
            return 0;
        }
        
        // use length() + 1 so that lcs[0][0] can be used as dummy starting point later
        int[][] lcs = new int[A.length() + 1][B.length() + 1];
        
        // start from 1 since lcs[0][0] is dummy starting point 
        for (int i = 1; i <= A.length(); i++){
            for (int j = 1; j <= B.length(); j++){
                if (A.charAt(i - 1) == B.charAt(j - 1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        
        for (int i = 1; i <= A.length(); i++){
            for (int j = 1; j <= B.length(); j++){
                max = Math.max(max, lcs[i][j]);
            }
        }
        
        return max;
        
    }
}
