package com.pecan.hope.sorting;

import java.util.Arrays;

/**
 * different basic sorting algorithm
 */
public class SortInteger {

   /*
     * @param A: an integer array
     * @return:
     */

    public void sortIntegers2(int[] A) {
        // quick sort
        // quick sort sorts array in place

        // pick middle as pivot
        // move everything smaller to left,
        // move everything greater to right
        // recursively do it for left and right
        if (A == null || A.length <= 1) {
            return;
        }
        quickSort2(A, 0, A.length - 1);


    }


    private void quickSort2(int[] A, int left, int right) {
        // first partition the array based on pivot
        // avoid overflow
        // elements at index is in its correct place
        int index = partition(A, left, right);
        if (index - 1 > left) {
            quickSort(A, left, index -1);
        }
        if (right > index ) {
            quickSort(A, index, right);
        }

    }

    private int partition(int[] A, int left, int right) {
        int pivot = A[left + (right - left)/2];

        while (left <= right) {
            while (A[left] < pivot) left++;
            while (A[right] > pivot) right--;

            if (left <= right) {
                swap(A, left, right);
                left++;
                right--;
            }
        }

        return left;

    }

    private void swap(int[] A, int idx1, int idx2) {
        int tmp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = tmp;
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2];

        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }

    public void sortIntegers2MergeSort(int[] A) {
        // write your code here
        int[] sorted = mergeSort(A);
        int i = 0;
        while (i < A.length) {
            // this cannot be A[i++] = sorted[i];
            // it evalutes from left to right
            // if A[i++] then for sort[i],
            // its i would be incremented already
            A[i] = sorted[i++];
        }

    }

    private int[] mergeSort(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }

        int mid = A.length/2;
        // start index is inclusive
        // end index is exclusive
        int[] left = Arrays.copyOfRange(A, 0, mid);
        int[] right = Arrays.copyOfRange(A, mid, A.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            result[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

}
