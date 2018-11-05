package com.pecan.hope.binarysearch;

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
	
	// pay attention to data type use long!
	
    public int mySolution(int x) {
        // write your code here
        
        // 5
        
        // 9
        
        // 2
        
        // 0
        
        // 1
        
        // 2 -> 0 1 2 -> 2
        
        long left = 0;
        long right = x;
        
        long mid = 0;
        
        while (left <= right) {
            mid = (left + right)/2;
        
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int)mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        // another way to do it
        // this will result in more iterations 
        
//        int ans = 0;
//        
//        while (left <= right) {
//        	
//        	mid = (left + right)/2;
//        	
//        	if (mid * mid == x) {
//        		return (int) mid;
//        	} else if (mid * mid > x) {
//        		right = mid - 1;
//        	} else {
//        		left = mid + 1;
//        		ans = (int) mid;
//        	}
//        	
//        	
//        	
//        }
//        
//        return ans;
        
        return (int)mid;
        
        
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
