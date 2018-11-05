package com.pecan.hope.yama;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3. int[] nums = {1,2,3}; Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3]. solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3]. solution.shuffle();
 * <p>
 * <p>
 * fisher - Yates algorithm
 */
public class ShuffleArray {
    int[] original;
    int[] tmp;
    // nextInt generates number between 0 (inclusive) to input (exclusive)
    Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.original = nums;
        this.tmp = Arrays.copyOf(nums, nums.length);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int pos = tmp.length - 1;

        while (pos > 0) {
            int randomIdx = random.nextInt(pos + 1);
            swap(tmp, pos, randomIdx);
            pos--;
        }

        return tmp;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
