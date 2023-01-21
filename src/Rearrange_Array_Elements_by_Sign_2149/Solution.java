package Rearrange_Array_Elements_by_Sign_2149;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {




    public static int[] rearrangeArray(int[] nums) {

        int cp = 0;
        int cn = 1;

        int array [] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                array[cn] = nums[i];
                cn+=2;
            }else{
                array[cp] = nums[i];
                cp+=2;
            }
        }

        return array;
    }


}
