package com.pecan.hope.bitwiseandmath;

/**
 * Using O(1) time to check whether an integer n is a power of 2.
 * 
 * Example For n=4, return true;
 * 
 * For n=5, return false;
 * 
 * @author Shilin
 *
 */
public class PowerOfTwo {
	/*
	 * @param n: An integer
	 * 
	 * @return: True or false
	 */
	public boolean checkPowerOf2(int n) {
		// write your code here

		return (n > 0) && (((n - 1) & n) == 0);
	}
}
