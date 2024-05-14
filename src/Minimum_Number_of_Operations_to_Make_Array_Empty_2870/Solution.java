package Minimum_Number_of_Operations_to_Make_Array_Empty_2870;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        System.out.println(minOperations(new int[]{2,1,2,2,3,3}));
        System.out.println(minOperations(new int[]{14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}));

    }



    public static int minOperations(int[] nums) {

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int count : counter.values()) {
            if(count == 1) return -1;
            res += (count + 2) / 3;
        }
        return res;
    }







}
