package com.shilin.hope.searchrecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as
 * follow:
 * 
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct
 * to it. Find any topological order for the given graph.
 * 
 * Notice
 * 
 * You can assume that there is at least one topological order in the graph.
 * 
 * @author Shilin_Gan
 *
 */
public class TopologicalSorting {
	/**
	 * @param graph:
	 *            A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */

	/*
	 * A topological ordering is possible if and only if the graph has no
	 * directed cycles, that is, if it is a directed acyclic graph (DAG). Any
	 * DAG has at least one topological ordering, and algorithms are known for
	 * constructing a topological ordering of any DAG in linear time.
	 */

	/*
	 * I assume the graph is DAG (directed acyclic graph) 0 {1,2,3} 1 {4} 2 {5}
	 * 3 {4,5} 4 {2} 5 {}
	 * 
	 * 
	 * 
	 * 0, 1, 2, 3, 4
	 * 
	 * 
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		// write your code here
		ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
		if (graph == null || graph.size() == 0) {
			return result;
		}

		Map<DirectedGraphNode, Integer> nodeIncoming = new HashMap<DirectedGraphNode, Integer>();
		for (DirectedGraphNode node : graph) {
			if (!nodeIncoming.containsKey(node)) {
				nodeIncoming.put(node, 0);
			}
			for (DirectedGraphNode neighbor : node.neighbors) {
				if (!nodeIncoming.containsKey(neighbor)) {
					nodeIncoming.put(neighbor, 1);
				} else {
					int incoming = nodeIncoming.get(neighbor);
					nodeIncoming.put(neighbor, ++incoming);
				}
			}
		}

		Queue<DirectedGraphNode> zeroDegreeNodes = new LinkedList<DirectedGraphNode>();
		for (Map.Entry<DirectedGraphNode, Integer> entry : nodeIncoming.entrySet()) {
			if (entry.getValue() == 0) {
				zeroDegreeNodes.offer(entry.getKey());
				result.add(entry.getKey());
			}
		}

		while (!zeroDegreeNodes.isEmpty()) {
			DirectedGraphNode node = zeroDegreeNodes.poll();
			for (DirectedGraphNode neighbor : node.neighbors) {
				int incoming = nodeIncoming.get(neighbor);
				if (--incoming == 0) {
					zeroDegreeNodes.offer(neighbor);
					// nodeIncoming.remove(neighbor);
					result.add(neighbor);
				} else {
					nodeIncoming.put(neighbor, incoming);
				}
			}
		}
		// not a DAG

		if (result.size() != graph.size()) {
			return new ArrayList<DirectedGraphNode>();
		}

		return result;
	}

	/**
	 * Definition for Directed graph.
	 */
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	};

}
