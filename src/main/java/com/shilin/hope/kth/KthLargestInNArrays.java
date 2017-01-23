package com.shilin.hope.kth;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kth Largest in N Arrays Example In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the
 * 3rd largest element is 7.
 * 
 * In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd
 * largest element is 8, 3rd largest element is 7 and etc.
 * 
 * @author Shilin_Gan
 *
 */

public class KthLargestInNArrays {

	class Node {
		// from_id denotes which array this element comes from
		public int value, from_id, index;

		public Node(int _v, int _id, int _i) {
			this.value = _v;
			this.from_id = _id;
			this.index = _i;
		}
	}

	/**
	 * @param arrays
	 *            a list of array
	 * @param k
	 *            an integer
	 * @return an integer, K-th largest element in N arrays
	 */
	public int KthInArrays(int[][] arrays, int k) {


		Queue<Node> maxHeap = new PriorityQueue<Node>(k, new Comparator<Node>() {
			// descending ordering !
			public int compare(Node o1, Node o2) {
				if (o1.value > o2.value)
					return -1;
				else if (o1.value < o2.value)
					return 1;
				else
					return 0;
			}

		});
		
		// number of input arrays
		int n = arrays.length;

		for (int i = 0; i < n; i++) {
			// sorted in ascending order
			Arrays.sort(arrays[i]);
			
			// put maximum value from each array into max heap
			if (arrays[i].length > 0){
				int fromId = i;
				int index = arrays[i].length - 1;
				int maxVal = arrays[i][index];
				maxHeap.add(new Node(maxVal, fromId, index));
			}
		}
		
		

		return -99;
	}
}
