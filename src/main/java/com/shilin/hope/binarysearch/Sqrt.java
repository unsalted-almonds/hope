package com.shilin.hope.binarysearch;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * Have you met this question in a real interview? Yes Example sqrt(3) = 1
 * 
 * sqrt(4) = 2
 * 
 * sqrt(5) = 2
 * 
 * sqrt(10) = 3
 * 
 * @author Shilin
 *
 */
public class Sqrt {
	
	public static void main(String args[]){
		System.out.println(new Sqrt().sqrt(999999999));
	}

	/**
	 * @param x:
	 *            An integer
	 * @return: The sqrt of x
	 */
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            long tmp = mid * mid;
            System.out.println("tmp = " + tmp);
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }

}
