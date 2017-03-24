package com.shilin.hope.array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 * 
 * Notice
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Example For example, given array S = [-1 2 1 -4], and target = 1. The sum
 * that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Shilin_Gan
 *
 */
public class ThreeSumClosest {
	
	public static void main(String args[]){
		
		int[] numbers = new int[]{2,7,11,15};
		int target = 3;
		
		new ThreeSumClosest().threeSumClosest(numbers, target);
	}

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        
        // ¶Ô×²ĞÍÖ¸Õë
        
        if (numbers == null || numbers.length < 3) {
            return 0;
        }
        
        // [-3, -1, 0 ,1 ,2, 3]
        
        Arrays.sort(numbers);
        
        int minDistance = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        int j, k;
        
        for (int i = 0; i < numbers.length; i++){
            j = i + 1;
            k = numbers.length - 1;
            
            while (j < k){
                
                int distance = target - numbers[i] - numbers[j] - numbers[k];
                int absoluteDist = Math.abs(distance);
                
                System.out.println("absoluteDist = " + absoluteDist);
                System.out.println("i = " + i + ", j = " + j + ", k = " + k);
                System.out.println("sum = " + (numbers[i] + numbers[j] + numbers[k]));
                
                if (absoluteDist == 0){
                    return target;
                } else if (absoluteDist < minDistance){
                    minDistance = absoluteDist;
                    minSum = numbers[i] + numbers[j] + numbers[k];
                } 
                
                if (distance > 0){
                    j++;
                } else {
                    k--;
                }
            }
            
        }
        
        return minSum;
        
    }

}
