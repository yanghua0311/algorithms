package com.youngwa.algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by youngwa on 2018年5月20日 广度优先搜索算法
 */
public class BFSAlgorithm {

	static Queue<String> sesrchQueue = new LinkedList<String>();
	static Map<String, List<String>> graph = new HashMap<>();
	static List<String> searcheds = new ArrayList<>();

	public static void main(String[] args) {
		initBaseValue();
		System.out.println(bfsAlgorithm());
	}

	// 对于已经处理过的姓名不能重复处理
	public static boolean bfsAlgorithm() {
		String start = "YOU";
		List<String> nameList = graph.get(start);
		for (String name : nameList) {
			sesrchQueue.offer(name);
		}
		while (sesrchQueue.size() > 0) {
			String name = sesrchQueue.poll();
			if (name.endsWith("M")) {
				return true;
			} else {
				searcheds.add(name);
				if (graph.get(name) != null) {
					List<String> list = graph.get(name);
					for (String string : list) {
						if (!searcheds.contains(string)) {
							sesrchQueue.offer(string);
						}
					}
				}

			}
		}
		return false;
	}

	public static void initBaseValue() {
		graph.put("YOU", new ArrayList<>(Arrays.asList("BOB", "ClAIRE", "ALICE")));
		graph.put("BOB", new ArrayList<>(Arrays.asList("ANUJ", "PEGGY")));
		graph.put("ClAIRE", new ArrayList<>(Arrays.asList("THOM", "JONNY")));
		graph.put("ALICE", new ArrayList<>(Arrays.asList("PEGGY")));
	}
}
