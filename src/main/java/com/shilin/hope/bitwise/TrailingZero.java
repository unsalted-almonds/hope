package com.shilin.hope.bitwise;

/**
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial. Example 11! = 39916800, so the out should be 2
 * 
 * @author Shilin
 *
 */
public class TrailingZero {
	
	public static void main (String args[]) {
		System.out.println(new TrailingZero().trailingZeros(8));
	}
	
	/*
	 * param n: As desciption return: An integer, denote the number of trailing
	 * zeros in n!
	 */
	public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
