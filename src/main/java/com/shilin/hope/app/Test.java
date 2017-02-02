package com.shilin.hope.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Test {
	
	public static void main(String args[]){
		
		// 11111111111111111111111111111110
		int num = -2;
		
		num = num >>> 1;
		
		System.out.println("num >> 1 = " + num + " binary = " + Integer.toBinaryString(num));

		

	        

	    
	}


public int KthInArrays(int[][] arrays, int k) {
    // Write your code here
    
    List<Integer> allElements = new ArrayList<Integer>();
    
//    for (int[] array : arrays){
//        allElements.addAll(Arrays.asList(array));
//    }
    
    for (int i = 0; i < arrays.length; i++){
    	
    	for (int j : arrays[i]){
    		allElements.add(j);
    	}
    	
    }
    Collections.reverse(allElements);
    
    return allElements.get(k - 1);
}

}
