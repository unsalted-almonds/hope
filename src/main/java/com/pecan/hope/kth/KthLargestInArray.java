package com.pecan.hope.kth;

/**
 * Find K-th largest element in an array.
 * <p>
 * Notice
 * <p>
 * You can swap elements in the array
 * <p>
 * Have you met this question in a real interview? Yes Example In array [9,3,2,4,8], the 3rd largest element is 4.
 * <p>
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 */
public class KthLargestInArray {
    /**
     * @param k    : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    // this can be achieved with a iterative way
    // http://www.jiuzhang.com/solution/kth-largest-element/
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        // use the method of quick sort
        // once pivot is been put to k, we're good

        if (k < 1 || nums == null || nums.length < k) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);


    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {

        if (lo >= hi) {
            return -1;
        }

        int index = partition(nums, lo, hi);

        if (index == nums.length - k) {
            return nums[index];
        } else if (index < nums.length - k) {
            return quickSelect(nums, index + 1, hi, k);
        } else {
            return quickSelect(nums, lo, index - 1, k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;

        while (i < j) {
            while (i <= hi && nums[i] < pivot) i++;
            while (j >= lo && nums[j] > pivot) j--;

            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        if (i == j && pivot < nums[i]) {
            swap(nums, lo, i - 1);
            return i - 1;
        }

        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public int kthLargestElement2(int k, int[] nums) {
        // write your code here
        // use the method of quick sort
        // once pivot is been put to k, we're good

        if (k < 1 || nums == null || nums.length < k) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int pivot = nums[lo];

        int i = lo + 1;
        int j = hi;


        while (i <= j) {
            while (i < j) {

                while (i <= hi && nums[i] < pivot) i++;
                while (j >= lo && nums[j] > pivot) j--;

                if (i < j) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
            }

            int index = 0;
            if (i == j && pivot < nums[i]) {
                swap(nums, lo, i - 1);
                index = i - 1;
            } else {
                swap(nums, lo, j);
                index = j;
            }

            if (index == nums.length - k) {
                return nums[index];
            } else if (index < nums.length - k) {
                lo = index + 1;
                i = lo + 1;
                j = hi;
            } else {
                hi = index - 1;
                i = lo + 1;
                j = hi;
            }
            pivot = nums[lo];
        }
        return -1;

    }
}

/**
 * to use this, nums must be of type Integer, int doesn't compile Arrays.sort(nums, Collections.reverseOrder()); return
 * nums[k - 1];
 **/