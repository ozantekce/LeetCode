package Contiguous_Array_525;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{0,1}));
        System.out.println(findMaxLength(new int[]{0,1,0}));
        System.out.println(findMaxLength(new int[]{0,1,0,1}));
        System.out.println(findMaxLength(new int[]{0,1,1}));
        System.out.println(findMaxLength(new int[]{1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1}));

    }



    public static int findMaxLength(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }

        HashMap<Integer, Integer> mapFirstIndex = new HashMap<>();
        mapFirstIndex.put(nums[0], 0);

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];

            if(nums[i] == 0)
                res = i+1;

            if(mapFirstIndex.containsKey(nums[i])){
                res = Math.max(res, i - mapFirstIndex.get(nums[i]));
            }else{
                mapFirstIndex.put(nums[i], i);
            }
        }

        return res;
    }




}
