package com.pecan.hope.palindrome;

public class PalindromeNumber {

    /*
 * @param num: a positive number
 * @return: true if it's a palindrome or false
 */
    public boolean isPalindrome(int num) {
        // write your code here

        if (num <= 0) {
            return false;
        }

        int tmp = num;
        long newNum = 0;
        while (tmp != 0) {
            int digit = tmp % 10;

            newNum = newNum * 10 + digit;

            tmp = tmp / 10;
        }

        return newNum == num;
    }
}
