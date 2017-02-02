package com.shilin.hope.string;


public class CompareStrings {
	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */

	/**
	 * "ABCDEFG", "ACC" should return false as A only has one C
	 */
	public boolean compareStrings(String A, String B) {
		// write your code here
		
		// difference between this one and the anagram one
		// this one doesn't check length!!

		int[] count = new int[128];
		
		for (int i = 0; i < A.length(); i++){
			count[(int) A.charAt(i)]++;
		}
		
		for (int j = 0; j < B.length(); j++){
			if (count[(int) B.charAt(j)]-- == 0){
				return false;
			}
		}

		return true;
	}

}
