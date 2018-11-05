package com.pecan.hope.bitwiseandmath;

/**
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
 * method to set all bits between i and j in N equal to M (e g , M becomes a
 * substring of N located at i and starting at j)
 * 
 * Clarification You can assume that the bits j through i have enough space to
 * fit all of M. That is, if M=10011�� you can assume that there are at least 5
 * bits between j and i. You would not, for example, have j=3 and i=2, because M
 * could not fully fit between bit 3 and bit 2.
 * 
 * Example Given N=(10000000000)2, M=(10101)2, i=2, j=6
 * 
 * return N=(10001010100)2
 * 
 * @author Shilin
 *
 */
public class UpdateBits {
	
	public static void main (String args[]){
		//System.out.println("" + Integer.toBinaryString((~0) >>> 12));
		
		//new UpdateBits().updateBits(1024, 21, 2, 6);
		
		System.out.println(new UpdateBits().updateBits(1024, 21, 2, 6));
	}
	
	/**
	 * @param n,
	 *            m: Two integer
	 * @param i,
	 *            j: Two bit positions return: An integer
	 */
	public int updateBits(int n, int m, int i, int j) {
		// write your code here

		m = m << i;
		
		int mask1 = (1 << i) - 1;
		int mask2 = ((1 << (32 - j + 1)) - 1) << j + 1;
		int mask3 = mask1 | mask2;
		
		System.out.println("mask1 = " + Integer.toBinaryString(mask1));
		System.out.println("mask2 = " + Integer.toBinaryString(mask2));
		System.out.println("mask3 = " + Integer.toBinaryString(mask3));
		
		int mask4 = mask3 | m;
		
		System.out.println("mask4 = " + Integer.toBinaryString(mask4));
		
		// set bits
		n = n | m;
		// clear bits
		n = n & mask4;

		return n;
	}
}
