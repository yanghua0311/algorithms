package com.youngwa.algorithm.sorting;

import java.util.Arrays;

/**
 * Created by youngwa on 2018??4??10??
 * ?????????
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] numarr  = {15,23,34,55,6,3}; 
		for (int i = 0; i < numarr.length; i++) {
			for(int j = 0; j < numarr.length; j++){
				if(numarr[i] > numarr[j]){
				   int temp = numarr[j];
				   numarr[j] = numarr[i];
				   numarr[i] = temp;
				   System.out.println("1111111111");
				}
			}
			System.out.println("??"+(i+1)+"??????  " + Arrays.toString(numarr));
		}
		System.out.println(Arrays.toString(numarr));
	}
}
