package com.pecan.hope.array;

/**
 * Given an array and a value, remove all occurrences of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed, and the elements after the new length
 * don't matter.
 * 
 * Example Given an array [0,4,4,0,0,2,4,4], value=4
 * 
 * return 4 and front four elements of the array is [0,0,0,2]
 * 
 * @author Shilin
 *
 */
public class RemoveElement {
	/**
	 * @param A:
	 *            A list of integers
	 * @param elem:
	 *            An integer
	 * @return: The new length after remove
	 */
    public int removeElement(int[] A, int elem) {
        // write your code here
        
        if (A == null || A.length == 0){
            return 0;
        }
        
        // this is just a simple two pointer stuff
        
        int j = A.length - 1;
        
        // [4,5,6] 
        // [4]
        // [4,5]
        // [4,5,6] i = 0, j = 2
        //             1      1
        //             2      1
        // [4,5,6,5]
        for (int i = 0; i < A.length;i++){
            
            while (A[i] == elem && i <= j){
                swap(A, i, j);
                j--;
            }
            
        }
        
        return j + 1;
    }
    
    private void swap(int[] A, int a, int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
