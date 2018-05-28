package com.youngwa.algorithm.np;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Sets;
import com.youngwa.algorithm.utils.ListUtil;

/**
 * Created by youngwa on 2018年5月28日 
 * 贪婪算法 
 * 每一步都取局部最优解，以达到全局最优解(只能是近视解)。
 */
public class Greedy {
	public static Map<String, Set<String>> stations = new HashMap<>();
	public static Set<String> stationNeed = new HashSet<>(
			Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
	public static Set<String> bestStations = new HashSet<>();
	public final static ListUtil<String> listUtil = (s1, s2) -> s1.forEach(s -> s2.add(s));

	public static void main(String[] args) {
		init();
		greedy();
		System.out.println(bestStations);
	}

	public static void greedy() {
		String bestStation = null;
		while (stationNeed.size() > 0) {
			Set<String> statesCovered = new HashSet<>();
			for (Entry<String, Set<String>> value : stations.entrySet()) {
				Set<String> station = value.getValue();
				Set<String> newStation = new HashSet<>();
				listUtil.copy(station, newStation);
				value.getValue().retainAll(stationNeed);
				if (value.getValue().size() > statesCovered.size()) {
					bestStation = value.getKey();
					statesCovered = station;
				}
			}
			stationNeed.removeAll(statesCovered);
			stations.remove(bestStation);
			bestStations.add(bestStation);
		}
	}

	public static void init() {
		Set<String> s1 = Sets.newHashSet("id", "nv", "ut");
		Set<String> s2 = Sets.newHashSet("wa", "id", "mt");
		Set<String> s3 = Sets.newHashSet("or", "nv", "ca");
		Set<String> s4 = Sets.newHashSet("nv", "ut");
		Set<String> s5 = Sets.newHashSet("ca", "az");
		stations.put("kone", s1);
		stations.put("ktwo", s2);
		stations.put("kthree", s3);
		stations.put("kfour", s4);
		stations.put("kfive", s5);
	}
}
