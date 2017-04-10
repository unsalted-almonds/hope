package com.shilin.hope.binarysearch;

/**
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.

 Notice

Please read the annotation in code area to get the correct way to call isBadVersion in different language. For example, Java is SVNRepo.isBadVersion(v)

Example
Given n = 5:

isBadVersion(3) -> false
isBadVersion(5) -> true
isBadVersion(4) -> true
Here we are 100% sure that the 4th version is the first bad version.

 * @author Shilin_Gan
 *
 */
public class FirstBadVersion {
	
	public static void main(String args[]){
		System.out.println(new FirstBadVersion().findFirstBadVersion(2147483647));
	}

    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        
        int ans = -1;
        
        if (n < 1) {
            return ans;
        }
        
        int left = 1;
        int right = n;
        
        int exit = 0;
        
        // don't do +1 inside loop. otherwise this may result in overflow
        while (left + 1 < right) {
            
            int mid = left + (right - left) / 2;
            
            if (SVNRepo.isBadVersion(mid) == true) {
                right = mid;
            } else {
                left = mid;
            }
            
            System.out.println("left = " + left + ", right = " + right);
            // left = 2147483647, right = 2147483647
            // this is when things no longer work
            // that's why we can't use left = mid + 1; use left = mid instead 
            
            if (++exit == 100){
            	break;
            }
            
        }
        
        if (SVNRepo.isBadVersion(left) == true) {
            return left;
        } else {
            return right;
        }
        
    }
    
    private static class SVNRepo{
    	
    	static boolean isBadVersion(int n){
    		if (n == 2147483647) {
    			return true;
    		}
    		
    		return false;
    	}
    	
    }
    
}
