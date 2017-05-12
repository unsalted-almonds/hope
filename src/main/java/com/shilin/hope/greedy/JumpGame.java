package com.shilin.hope.greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * This problem have two method which is Greedy and Dynamic Programming.
 * 
 * The time complexity of Greedy method is O(n).
 * 
 * The time complexity of Dynamic Programming method is O(n^2).
 * 
 * We manually set the small data set to allow you pass the test in both ways.
 * This is just to let you learn how to use this problem in dynamic programming
 * ways. If you finish it in dynamic programming ways, you can try greedy method
 * to make it accept again.
 * 
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author Shilin
 *
 */
public class JumpGame {
	/**
	 * @param A:
	 *            A list of integers
	 * @return: The boolean answer
	 */
	public boolean canJump(int[] A) {
		// wirte your code here

		if (A == null || A.length == 0) {
			return true;
		}

		int nextPosition = 0;

		for (int i = 0; i < A.length; i++) {
			if (i + A[i] > nextPosition) {
				nextPosition = i + A[i];
			}

			if (nextPosition < i + 1 && i < A.length - 1) {
				return false;
			}
		}

		return true;
	}
	
	// version 1: Dynamic Programming
	// 这个方法，复杂度是 O(n^2) 可能会超时，但是依然需要掌握。
    public boolean canJumpDp(int[] A) {
        boolean[] can = new boolean[A.length];
        can[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[A.length - 1];
    }
}
