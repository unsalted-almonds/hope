package com.shilin.hope.dp;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be break
 * into a space-separated sequence of one or more dictionary words. Given s =
 * "lintcode", dict = ["lint", "code"].
 * 
 * Return true because "lintcode" can be break as "lint code".
 * 
 * lintcode1 -> false
 * 
 * @author Shilin
 *
 */
public class WordBreak {
	/**
	 * @param s:
	 *            A string s
	 * @param dict:
	 *            A dictionary of words dict
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		
		if (s == null || dict == null || s.length() == 0){
			return false;
		}
		
		int lastSpace = 0;
		
		for (int i = 0; i < s.length(); i++){
			
		}
		
		return false;
	}
}
