package com.youngwa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by youngwa on 2018/4/17.
 */
public class FastSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(15,6,4,2,4,9));
        System.out.println(quickSort(arr));
    }

    public static  List<Integer>  quickSort( List<Integer> arr){
        if(arr.size()<2){
            return arr;
        }else {
            int one = arr.get(0);
            List<Integer> rightarr = new ArrayList<Integer>();
            List<Integer> leftarr = new ArrayList<Integer>();
            for (int i = 1; i < arr.size(); i++) {
                if(arr.get(i) < one){
                    rightarr.add(arr.get(i));
                }else{
                    leftarr.add(arr.get(i));
                }
            }
            List<Integer> newright = quickSort(rightarr);
            List<Integer> newleft = quickSort(leftarr);
            List<Integer> all = new ArrayList<Integer>();
            all.addAll(newright);
            all.add(one);
            all.addAll(newleft);
            return  all;
        }
    }
}
