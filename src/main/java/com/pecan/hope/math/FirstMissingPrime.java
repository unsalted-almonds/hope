package com.pecan.hope.math;

/**
 * Given a list of integers and find the smallest prime number that doesn't appear in this list.
 * <p>
 * Have you met this question in a real interview? Yes Example Given a list [2,3,5,7,11,13,17,23,29] return 19
 */
public class FirstMissingPrime {
    /*
 * @param : an array of integer
 * @return: the first missing prime number
 */
    public int firstMissingPrime(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 2;
        }

        int i = 0;
        int prev = 0;

        while (i <= nums.length) {
            for (int k = prev + 1; k < Integer.MAX_VALUE; k++) {
                if (isPrime(k)) {
                    prev = k;
                    // if couldn't find in given array, return the next
                    if (i == nums.length || (i < nums.length && nums[i] != k)) {
                        return k;
                    }
                    break;
                }
            }
            i++;
        }

        return -1;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
