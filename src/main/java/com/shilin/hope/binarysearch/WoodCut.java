package com.shilin.hope.binarysearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into small
 * pieces to guarantee you could have equal or more than k pieces with the same
 * length. What is the longest length you can get from the n pieces of wood?
 * Given L & k, return the maximum length of the small pieces.
 * 
 * Notice
 * 
 * You couldn't cut wood into float length.
 * 
 * If you couldn't get >= k pieces, return 0.
 * 
 * For L=[232, 124, 456], k=7, return 114.
 * 
 * @author Shilin
 *
 */
public class WoodCut {
	

	public static void main (String args[]) throws NumberFormatException, IOException{
		int k = 2500;
		List<Integer> inputList = new ArrayList<Integer>();
		
		BufferedReader br = new BufferedReader(new FileReader("woodcut.txt"));
	    String line = null;

	    while ((line = br.readLine()) != null) {
	      String[] values = line.split(",");
	      for (String str : values) {
	    	  inputList.add(Integer.parseInt(str));
	      }
	    }
	    br.close();
	    
	    Integer[] input = inputList.toArray(new Integer[]{});
	    
	    //System.out.println(input.length);
	    
	    System.out.println(new WoodCut().woodCut(input, k));
	    
	  }
	
		
		
		//System.out.println(new WoodCut().woodCut(input, k));
		
	
	
	public int woodCut(Integer[] L, int k) {

		// write your code here
		if (L == null || L.length == 0 || k <= 0) {
			return 0;
		}

		long left = 0;
		long right = 0;

		for (int n : L) {
			right += n;
		}

		right = right / k;

		while (left + 1 < right) {

			long mid = left + (right - left) / 2;

			long num = 0;

			for (int n : L) {
				num += n / mid;
			}

			if (num < k) {
				right = mid;
			} else {
				left = mid;
			}

		}

		int leftCut = 0;

		if (left != 0) {
			for (int n : L) {
				leftCut += n / left;
			}
			System.out.println("leftCut = " + leftCut);
			System.out.println("left = " + left);

			if (leftCut == k) {
				return (int) left;
			}
		}

		int rightCut = 0;
		if (right != 0) {
			for (int n : L) {
				rightCut += n / right;
			}
			System.out.println("rightCut = " + rightCut);
			System.out.println("right = " + right);

			if (rightCut == k) {
				return (int) right;
			}
		}
		
		if (leftCut > k && leftCut > rightCut) {
			return (int)left;
		}
		
		if (rightCut > k && leftCut < rightCut) {
			return (int)right;
		}

		return 0;

	}
}
