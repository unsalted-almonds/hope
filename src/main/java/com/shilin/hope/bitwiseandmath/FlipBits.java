package com.shilin.hope.bitwiseandmath;

/**
 * Determine the number of bits required to flip if you want to convert integer
 * n to integer m.
 * 
 * Notice
 * 
 * Both n and m are 32-bit integers.
 * 
 * Given n = 31 (11111), m = 14 (01110), return 2.
 * 
 * @author Shilin
 *
 */
public class FlipBits {

	public static void main(String args[]) {

		System.out.println("-1 binary = " + Integer.toBinaryString(-1));
		// arithmetic shift
		System.out.println("-1 >> 1 binary = " + Integer.toBinaryString(-1 >> 1));
		// logical shift
		System.out.println("-1 >>> 1 binary = " + Integer.toBinaryString(-1 >>> 1));
		System.out.println(-1 >> 1);

	}

	/**
	 * @param a,
	 *            b: Two integer return: An integer
	 */
	public static int bitSwapRequired(int a, int b) {
		// write your code here

		int ans = 0;

		while (a != b) {
			int x = a & 1;
			int y = b & 1;

			if (x != y) {
				ans++;
			}

			a = a >>> 1;
			b = b >>> 1;
		}

		return ans;
	}

}
