package com.pecan.hope.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianII {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    private PriorityQueue<Integer> maxHeap, minHeap;
    private int numOfElements = 0;

    public int[] medianII(int[] nums) {
        // write your code here
        Comparator<Integer> revCmp = new Comparator<Integer>() {
            //@Override
            public int compare(Integer left, Integer right) {
                return right.compareTo(left);
            }
        };
        int cnt = nums.length;
        maxHeap = new PriorityQueue<Integer>(cnt, revCmp);
        minHeap = new PriorityQueue<Integer>(cnt);
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; ++i) {
            addNumber(nums[i]);
            ans[i] = getMedian();
        }
        return ans;
    }
    void addNumber(int value) {
        maxHeap.add(value);
        if (numOfElements%2 == 0) {
            if (minHeap.isEmpty()) {
                numOfElements++;
                return;
            }
            else if (maxHeap.peek() > minHeap.peek()) {
                Integer maxHeapRoot = maxHeap.poll();
                Integer minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        }
        else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }
    int getMedian() {
        return maxHeap.peek();
    }

    /**
     * class MedianFinder {
     PriorityQueue<Integer> maxHeap;//lower half
     PriorityQueue<Integer> minHeap;//higher half

     public MedianFinder(){
     maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
     minHeap = new PriorityQueue<Integer>();
     }

     // Adds a number into the data structure.
     public void addNum(int num) {
     maxHeap.offer(num);
     minHeap.offer(maxHeap.poll());

     if(maxHeap.size() < minHeap.size()){
     maxHeap.offer(minHeap.poll());
     }
     }

     // Returns the median of current data stream
     public double findMedian() {
     if(maxHeap.size()==minHeap.size()){
     return (double)(maxHeap.peek()+(minHeap.peek()))/2;
     }else{
     return maxHeap.peek();
     }
     }
     }
     */
}

