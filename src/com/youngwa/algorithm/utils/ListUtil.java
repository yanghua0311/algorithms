package com.youngwa.algorithm.utils;

import java.util.Set;

/**
 * Created by youngwa on 2018年5月28日
 *
 */
@FunctionalInterface
public interface ListUtil<T>{
	 void copy (Set<T> src, Set<T> goal);
}
