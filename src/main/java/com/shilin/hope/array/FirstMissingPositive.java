package com.shilin.hope.array;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Example Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * @author Shilin_Gan
 *
 */
public class FirstMissingPositive {
	
	public static void main(String args[]){
		
		int[] array = new int[]{99,94,96,11,92,5,91,89,57,85,66,63,84,81,79,61,74,78,77,30,64,13,58,18,70,69,51,12,32,34,9,43,39,8,1,38,49,27,21,45,47,44,53,52,48,19,50,59,3,40,31,82,23,56,37,41,16,28,22,33,65,42,54,20,29,25,10,26,4,60,67,83,62,71,24,35,72,55,75,0,2,46,15,80,6,36,14,73,76,86,88,7,17,87,68,90,95,93,97,98};
		
		System.out.println("length of array = " + array.length);
		
		System.out.println("ans = " + new FirstMissingPositive().firstMissingPositive(array));
	}
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here  
        
        for (int i = 0; i < A.length; i++){
            
            
            if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]){
                
                int tmp = A[A[i] - 1];
                
                A[A[i] - 1] = A[i];
                
                // worst case, it adjust position for n elements
                // if it happens, then the loop for other elements would not need to enter while loop
                // so amortized worst case is still O(n)
                while (tmp > 0 && tmp <= A.length && A[tmp - 1] != tmp){
                    int tmp1 = A[tmp - 1];
                    A[tmp - 1] = tmp;
                    tmp = tmp1;
                }
                
                
            }
            
            //System.out.println(Arrays.toString(A));
            
        }
        
        System.out.println(Arrays.toString(A));
        
        
        int k = 0;
        for (k = 0; k < A.length; k++){
            
            if (A[k] != k + 1){
                return k + 1;
            }
            
        }
        
        System.out.println("k = " + k);
        
        return ++k;

    }
}
