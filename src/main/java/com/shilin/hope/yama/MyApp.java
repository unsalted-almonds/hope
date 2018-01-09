package com.shilin.hope.yama;

public class MyApp {

    public static void main(String args[]) {

        String s = "1";

        System.out.println(s.substring(1));

        MyApp test = new MyApp();

        System.out.println(test.kthLargestElement(3, new int[]{9, 3, 2, 4, 8}));
        //test.kthLargestElement(3, new int[]{9, 3, 2, 4, 8});

    }


    public int kthLargestElement(int k, int[] nums) {
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
}
