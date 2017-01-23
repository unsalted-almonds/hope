package com.shilin.hope.bitwise;

/**
 * Count how many 1 in binary representation of a 32-bit integer.
 * 
 * @author Shilin_Gan
 *
 */
public class CountOne {

	public class Solution {
		/**
		 * @param num:
		 *            an integer
		 * @return: an integer, the number of ones in num
		 */
		public int countOnes(int num) {
			// write your code here

			int result = 0;

			int digit;

			// watch out for negative number
			while (num != 0) {
				digit = num & 1;

				if (digit == 1)
					result++;
				num = num >>> 1;
			} ;

			return result;

		}
	};
	
	/**
	 * public class Solution {

    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
};
	 */
}
