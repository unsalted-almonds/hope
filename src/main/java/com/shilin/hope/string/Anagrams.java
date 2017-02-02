package com.shilin.hope.string;

/**
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * 
 * Clarification What is Anagram? - Two strings are anagram if they can be the
 * same after change the order of characters.
 * 
 * Example Given s = "abcd", t = "dcab", return true. Given s = "ab", t = "ab",
 * return true. Given s = "ab", t = "ac", return false.
 * 
 * @author Shilin_Gan
 *
 */
public class Anagrams {
	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public boolean anagram(String s, String t) {
		// write your code here

		// once length is equal, then the substraction works
		if (s == null || t == null || s.length() != t.length())
			return false;

		// hash map also works but array seems to be most efficient
		int[] count = new int[128];

		// do not use s.charAt(i) - '0', space's ascii value is 32, 0 is 48,
		// substraction will result in negative number
		// use this track when things are all numbers
		for (int i = 0; i < s.length(); i++) {

			count[(int) s.charAt(i)]++;
		}

		for (int j = 0; j < t.length(); j++) {
			if (count[(int) t.charAt(j)]-- == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String args[]) {
		String s = "happy new year";
		String t = "n ahwryeypp ea";

		System.out.println(new Anagrams().anagram(s, t));
	}
}
