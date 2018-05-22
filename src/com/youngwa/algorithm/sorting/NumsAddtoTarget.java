package com.youngwa.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youngwa on 2018/4/18.
 */
public class NumsAddtoTarget {

    public static void main(String[] args) {
        int[] nums = new int[]{2,8,11,7};
        System.out.println(Arrays.toString(get(nums,9)) );

    }

    public static int[] get(int[] nums , int target){
        List<Integer> arrs = new ArrayList<Integer>(Arrays.asList(2,7,11,15));
       for (int i = 0; i < arrs.size();i++){
           for(int j = i+1; j<arrs.size();j++){
               if(arrs.get(i)+arrs.get(j) == target){
                    return new int[]{getIndex(nums,arrs.get(i)),getIndex(nums,arrs.get(j))};
               }
           }
        }
        return null;

    }

    public int sum( List<Integer> arrs ){
        int a = 0;
        for ( Integer i :arrs) {
            a = a + i;
        }
        return a;
    }

    public static int getIndex(int[] arrs ,int a){
        for (int i = 0; i < arrs.length; i++) {
            if(arrs[i] == a){
                return i;
            }
        }
        return 0;
    }
}
