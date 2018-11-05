package com.pecan.hope.string;

/**
 * For a given source string and a target string, you should output the first
 * index(from 0) of target string in source string.
 * 
 * If target does not exist in source, just return -1. Clarification Do I need
 * to implement KMP Algorithm in a real interview?
 * 
 * Not necessary. When you meet this problem in a real interview, the
 * interviewer may just want to test your basic implementation ability. But make
 * sure your confirm with the interviewer first. Example If source = "source"
 * and target = "target", return -1.
 * 
 * If source = "abcdabcdefg" and target = "bcd", return 1.
 * 
 * @author Shilin_Gan
 *
 */
public class StrStr {
	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
        // write your code here
        
        if (source == null || target == null)
            return -1;
        
        return source.indexOf(target);
	}
	
	public int strStrhard(String source, String target) {
        // write your code here
        
        if (source == null || target == null)
            return -1;
        
        char firstTarget = target.charAt(0);
        
        for (int i = 0; i < source.length() && source.length() - i >= target.length(); i++){
        	if (source.charAt(i) == firstTarget){
        		int m = i;
        		int n = 0;
        		
        		while (n < target.length()){
        			if (source.charAt(m) != target.charAt(n))
        				break;
        			m++;
        			n++;
        		}
        		
        		if (n == target.length() - 1)
        			return i;
        	}
        }
        
        return -1;
	}
	
    public int strStrStandard(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
            	// this looks nice
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
