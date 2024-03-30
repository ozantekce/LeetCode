package Circular_Array_Loop_457;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(circularArrayLoop(new int[]{2,-1,1,2,2}));
        //System.out.println(circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
        //System.out.println(circularArrayLoop(new int[]{1,-1,5,1,4}));
        //System.out.println(circularArrayLoop(new int[]{2,-1,1,-2,-2}));
        //System.out.println(circularArrayLoop(new int[]{1,1,2}));
        //System.out.println(circularArrayLoop(new int[]{1,2,3,4,5}));
        //System.out.println(circularArrayLoop(new int[]{4,1,1,1,2}));
        //System.out.println(circularArrayLoop(new int[]{-1,-2,-3,-4,-5}));
        //System.out.println(circularArrayLoop(new int[]{2,2,2,2,2,4,7}));
        System.out.println(circularArrayLoop(new int[]{-1,-1,-1}));



    }


    public static boolean circularArrayLoop(int[] nums) {

        boolean [] forwards = new boolean[nums.length];

        for (int i = 0; i < forwards.length; i++) {
            forwards[i] = nums[i] > 0;
            int index = (i + nums[i]) % nums.length;
            if(index<0){
                index = index + nums.length;
            }
            nums[i] = index;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!forwards[i])
                continue;
            int next = nums[i];
            if(!forwards[next] || next == i)
                continue;
            nums[i] = Math.max(nums[next], nums[i]);
            nums[i] = Math.max(nums[nums[i]], nums[i]);
            if(i == nums[i])
                return true;
        }


        for (int i = 0; i < nums.length; i++) {
            if(forwards[i])
                continue;
            int next = nums[i];
            if(forwards[next] || next == i)
                continue;
            nums[i] = Math.max(nums[next], nums[i]);
            nums[i] = Math.max(nums[nums[i]], nums[i]);
            if(i == nums[i])
                return true;
        }


        return false;

    }

}
