package com.shilin.hope.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 1, 4, 5};
        new QuickSort().solution(input);
        System.out.println(Arrays.toString(input));
    }

    // sort input
    public void solution(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    // there are different ways of choosing pivot
    // here i use the original choice which use lowest indexed element
    // this can be extended to quick select algorithm
    // choosing numbers in the middle would be difficult for converting it to quick select
    private void quickSort(int[] A, int lo, int hi) {
        if (A == null || A.length <= 1 || lo >= hi) {
            return;
        }
        int index = partition(A, lo, hi);
        quickSort(A, lo, index - 1);
        quickSort(A, index + 1, hi);
    }

    private int partition(int[] A, int lo, int hi) {
        int pivot = A[lo];
        int i = lo + 1;
        int j = hi;

        while (i < j) {
            // make sure this part is solid
            while (i <= hi && A[i] < pivot) i++;
            while (j >= lo && A[j] > pivot) j--;

            if (i < j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }

        // make sure to know which one to swap
        if (i == j && A[i] > pivot) {
            swap(A, lo, i - 1);
            return i - 1;
        }
        swap(A, lo, j);
        return j;
    }

    private void swap(int[] A, int p1, int p2) {
        int tmp = A[p1];
        A[p1] = A[p2];
        A[p2] = tmp;
    }
}
