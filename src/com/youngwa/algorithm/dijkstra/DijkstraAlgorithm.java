package com.youngwa.algorithm.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by youngwa on 2018年5月20日 
 * 狄克斯特拉算法（不适用于带有负权边的情况）
 */
public class DijkstraAlgorithm {
	public static final int MAX_INT = 999999;

	static Map<String, Map<String, Integer>> graph = new HashMap<>(); // 邻居节点权重表
	static Map<String, Integer> costs = new HashMap<>(); // 开销表
	static Map<String, String> parents = new HashMap<>(); // 存储父节点
	static List<String> processed = new ArrayList<>(); // 记录已经处理过的节点

	public static void main(String[] args) {
		Dijalgorithm();
		System.out.println(costs);
		System.out.println(parents);
	}

	// 算法
	public static void Dijalgorithm() {
		initBaseValueForPiano();
		String node = findLowestCostNode(costs);
		while (node != null && !node.equals("")) {
			int cost = costs.get(node);
			Map<String, Integer> neighbors = graph.get(node);
			if (neighbors == null) {
				break;
			}
			for (Entry<String, Integer> n : neighbors.entrySet()) {
				int newCost = n.getValue() + cost;
				if (costs.get(n.getKey()) > newCost) {
					costs.put(n.getKey(), newCost);
					parents.put(n.getKey(), node);
				}
			}
			processed.add(node);
			node = findLowestCostNode(costs);
		}
	}

	public static void initBaseValue() {
		// 初始化路线
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("a", 6);
		tempMap.put("b", 2);
		graph.put("start", tempMap);

		Map<String, Integer> tempMap1 = new HashMap<String, Integer>();
		tempMap1.put("fin", 1);
		graph.put("a", tempMap1);

		Map<String, Integer> tempMap3 = new HashMap<String, Integer>();
		tempMap3.put("a", 3);
		tempMap3.put("fin", 5);
		graph.put("b", tempMap3);

		// 初始化开销表
		costs.put("a", 6);
		costs.put("b", 2);
		costs.put("fin", MAX_INT);

		// 初始化父节点
		parents.put("a", "start");
		parents.put("b", "start");
		parents.put("fin", "");
	}

	public static void initBaseValueForPiano() {
		// 初始化所有交换路线
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("黑胶唱片", 5);
		tempMap.put("海报", 0);
		graph.put("乐谱", tempMap);

		Map<String, Integer> tempMap1 = new HashMap<String, Integer>();
		tempMap1.put("低音吉他", 15);
		tempMap1.put("架子鼓", 20);
		graph.put("黑胶唱片", tempMap1);

		Map<String, Integer> tempMap3 = new HashMap<String, Integer>();
		tempMap3.put("低音吉他", 30);
		tempMap3.put("架子鼓", 35);
		graph.put("海报", tempMap3);

		Map<String, Integer> tempMap4 = new HashMap<String, Integer>();
		tempMap4.put("钢琴", 20);
		graph.put("低音吉他", tempMap4);

		Map<String, Integer> tempMap5 = new HashMap<String, Integer>();
		tempMap5.put("钢琴", 10);
		graph.put("架子鼓", tempMap5);

		// 初始化开销表
		costs.put("黑胶唱片", 5);
		costs.put("海报", 0);
		costs.put("低音吉他", MAX_INT);
		costs.put("架子鼓", MAX_INT);
		costs.put("钢琴", MAX_INT);

		// 初始化父节点
		parents.put("黑胶唱片", "乐谱");
		parents.put("海报", "乐谱");
		parents.put("钢琴", "");

	}

	// 找到开销表中最小且未被处理过的节点
	public static String findLowestCostNode(Map<String, Integer> costs) {
		int lowestCost = MAX_INT;
		String lowestNode = null;
		for (Entry<String, Integer> cost : costs.entrySet()) {
			String key = cost.getKey();
			if (cost.getValue() < lowestCost && !processed.contains(key)) {
				lowestCost = cost.getValue();
				lowestNode = key;
			}
		}
		return lowestNode;
	}
}
