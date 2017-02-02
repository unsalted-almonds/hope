package com.shilin.hope.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author Shilin_Gan
 *
 */
public class HouseRobber {

	public int rob(int[] nums) {
		
		if (nums == null || nums.length == 0){
			return 0;
		}
		
		int[] maxMoney = new int[nums.length];
		
		// at the first house
		maxMoney[0] = nums[0];
		
		if (nums.length == 1){
			return maxMoney[0];
		}
		
		// at the second house
		maxMoney[1] = Math.max(maxMoney[0], nums[1]);
		
		if (nums.length == 2){
			return maxMoney[1];
		}
				
		for (int i = 2; i < nums.length; i++){
			maxMoney[i] = Math.max(maxMoney[i-1], maxMoney[i-2] + nums[i]);
		}
		
		return maxMoney[maxMoney.length-1];
	}

}
