package com.shilin.hope.yama;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element. For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestInArray {
    // iterative
    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;

        while (true) {
            int split = partition(nums, k, lo, hi);
            if (split == nums.length - k) {
                return nums[split];
            } else if (split > nums.length - k) {
                hi = split - 1;
            } else {
                lo = split + 1;
            }
        }

    }

    // use last element as pivot
    private int partition(int[] nums, int k, int lo, int hi) {
        int pivot = hi;
        int idx = lo;

        for (int i = lo; i < hi; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, idx, i);
                idx++;
            }
        }

        swap(nums, idx, pivot);
        return idx;
    }


    /**
     *     public int kthLargestElement(int k, int[] nums) {
     // write your code here

     int result = Integer.MIN_VALUE;

     if (nums == null || nums.length == 0 || k > nums.length) {
     return result;
     }

     int lo = 0, hi = nums.length - 1;
     int idx = -1;

     while (true) {
     idx = partition(lo, hi, nums);
     if (idx > k - 1) {
     hi = idx - 1;
     } else if (idx < k - 1) {
     lo = idx + 1;
     } else {
     return nums[idx];
     }
     }

     }

     private int partition(int lo, int hi, int[] nums) {
     int pivot = hi;
     int idx = lo;

     for (int i = lo; i < hi; i++) {
     if (nums[i] > nums[pivot]) {
     swap(nums, i, idx);
     idx++;
     }
     }

     swap(nums, idx, pivot);
     return idx;
     }

     private void swap(int[] nums, int a, int b) {
     int tmp = nums[a];
     nums[a] = nums[b];
     nums[b] = tmp;
     }
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        // use first element as pivot
        int left = lo + 1, right = hi, pivot = lo;

        while (left < right) {
            while (left <= hi && nums[left] > nums[pivot]) left++;
            while (right >= lo && nums[right] < nums[pivot]) right--;

            // after this step left might be greater than right
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        int split = 0;

        if (left > right) {
            swap(nums, pivot, right);
            split = right;
        }

        if (left == right) {
            if (nums[left] > nums[pivot]) {
                swap(nums, pivot, left);
                split = left;
            } else {
                swap(nums, pivot, left - 1);
                split = left - 1;
            }
        }

        if (split == k - 1) {
            return nums[split];
        } else if (split < k - 1) {
            return quickSelect(nums, split + 1, hi, k);
        } else {
            return quickSelect(nums, lo, split - 1, k);
        }

    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
