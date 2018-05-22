package com.youngwa.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by youngwa on 2018/4/17.
 */
public class SumRecursion {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(sum(arr));

    }
        public static int sum(List<Integer> arr){
        if(arr.size()== 0){
            return 0;
        }else{
            int a =arr.get(0);
            arr.remove(0);
            return a + sum(arr);
        }
    }
}
