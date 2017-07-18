package com.shilin.hope.followup;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Find the kth smallest number in at row and column sorted matrix.
 * 
 * Example Given k = 4 and a matrix:
 * 
 * [ [1 ,5 ,7], [3 ,7 ,8], [4 ,8 ,9], ] return 5
 * 
 * @author Shilin
 *
 */
public class KthSmallestSortedMatrix {
	/**
	 * @param matrix:
	 *            a matrix of integers
	 * @param k:
	 *            an integer
	 * @return: the kth smallest number in the matrix
	 */

	/*
	 * [1 ,5 ,7], [3 ,7 ,8], [4 ,8 ,9],
	 */

	public int kthSmallest(int[][] matrix, int k) {
		// write your code here

		if (matrix == null || matrix.length * matrix[0].length < k) {
			return -1;
		}

		int rowSize = matrix.length;
		int columnSize = matrix[0].length;

		Queue<Element> candidates = new PriorityQueue<Element>(3, new ElementComparator());

		candidates.add(new Element(0, 0, matrix[0][0]));

		int i = 0;
		Element ithSmallest = null;
		
		// this can change to boolean[][] visited = new boolean[rowSize][columnSize]
		Set<String> visited = new HashSet<String>();
		visited.add("" + 0 + "+" + 0);

		while (i < k) {
			ithSmallest = candidates.poll();

			int ithX = ithSmallest.getX();
			int ithY = ithSmallest.getY();
			
			// think about vector 
	        //int[] dx = new int[]{0, 1};
	        //int[] dy = new int[]{1, 0};
			// for (int j = 0; j < 2; j++) {}
			if (ithX + 1 < rowSize && !visited.contains("" + (ithX + 1) + "+" + ithY)) {
				candidates.add(new Element(ithX + 1, ithY, matrix[ithX + 1][ithY]));
				visited.add("" + (ithX + 1) + "+" + ithY);
			}
			if (ithY + 1 < columnSize && !visited.contains("" + ithX + "+" + (ithY + 1))) {
				candidates.add(new Element(ithX, ithY + 1, matrix[ithX][ithY + 1]));
				visited.add("" + ithX + "+" + (ithY + 1));
			}

			i++;
		}

		return ithSmallest.getValue();
	}

	private static class ElementComparator implements Comparator<Element> {
		@Override
		public int compare(Element a, Element b) {
			// this can just be
			// return a.getValue() - b.getValue();
			if (a.getValue() < b.getValue()) {
				return -1;
			} else if (a.getValue() > b.getValue()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private static class Element {
		private int x;
		private int y;
		private int value;

		public Element(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getValue() {
			return value;
		}
	}

	/*
	 * class Pair {
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}

public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairComparator());
        minHeap.add(new Pair(0, 0, matrix[0][0]));

        for(int i = 0; i < k - 1; i ++){
            Pair cur = minHeap.poll();
            for(int j = 0; j < 2; j ++){
                int next_x = cur.x + dx[j];
                int next_y = cur.y + dy[j];
                Pair next_Pair = new Pair(next_x, next_y, 0);
                if(next_x < n && next_y < m && !hash[next_x][next_y]){
                    hash[next_x][next_y] = true;
                    next_Pair.val = matrix[next_x][next_y];
                    minHeap.add(next_Pair);
                }
            }
        }
        return minHeap.peek().val;
    }
}

	 * */
}
