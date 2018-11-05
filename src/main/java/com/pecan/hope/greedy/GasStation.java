package com.pecan.hope.greedy;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author Shilin
 *
 */
public class GasStation {
	public static void main(String args[]){
		int[] gas = new int[]{1,2,3,3};
		int[] cost = new int[]{2,1,5,1};
		new GasStation().canCompleteCircuit(gas, cost);
	}
	/**
	 * @param gas:
	 *            an array of integers
	 * @param cost:
	 *            an array of integers
	 * @return: an integer
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// write your code here

		if (gas == null || gas.length == 0) {
			return -1;
		}
		int debt = 0;
		int currentGas = 0;
		int res = 0;
		for (int i = 0; i < gas.length; i++) {
			if (currentGas + gas[i] >= cost[i]) {
				currentGas = currentGas + gas[i] - cost[i];
			} else {
				debt += cost[i] - currentGas - gas[i];
				currentGas = 0;
				res = i + 1;
				
			}
			
			System.out.println("debt = " + debt);
			System.out.println("current gas = " + currentGas);
			System.out.println("res = " + res);
		}

		if (res > gas.length - 1 || currentGas < debt) {
			return -1;
		}

		return res;
	}
}
