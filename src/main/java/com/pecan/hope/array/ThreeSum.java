package com.pecan.hope.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * <p>
 * Example For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * <p>
 * (-1, 0, 1) (-1, -1, 2)
 *
 * @author Shilin_Gan
 */
public class ThreeSum {

    // pay attention to how calculation is reduced by checking for duplicates
    // this needs to be thought through


    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        int p1 = 0;
        int p2 = 1;
        int p3 = numbers.length - 1;

        // move p1 till only three elements left
        while (p1 < numbers.length - 2) {
            p2 = p1 + 1;
            p3 = numbers.length - 1;

            while (p2 < p3) {

                int sum = numbers[p1] + numbers[p2] + numbers[p3];

                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(numbers[p1], numbers[p2], numbers[p3])));
                    // skip same
                    p2++;
                    while (p2 < p3 && numbers[p2] == numbers[p2 - 1]) {
                        p2++;
                    }
                    p3--;
                    while (p2 < p3 && numbers[p3] == numbers[p3 + 1]) {
                        p3--;
                    }

                } else if (sum < 0) {
                    // increase p2
                    p2++;
                } else {
                    // decrease p3
                    p3--;
                }
            }

            p1++;
            while (p1 < numbers.length && numbers[p1] == numbers[p1 - 1]) {
                p1++;
            }
        }

        return result;

    }
}
