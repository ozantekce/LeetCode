package Jump_Game_55;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));

    }



    public static boolean canJump(int[] nums){

        if(nums.length == 1){
            return true;
        }
        boolean [] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length-1 ; i++) {
            if(!dp[i])
                continue;

            for (int j = 1; j <= nums[i] && i+j<nums.length ; j++) {
                if(nums[i] >= j){
                    dp[i+j] = true;
                    if(i+j == nums.length-1){
                        return true;
                    }
                }
            }
        }

        return dp[nums.length-1];
    }

    private static byte[] Memory;
    private static boolean recursive(int index, int[] nums){

        if(index >= nums.length)
            return false;
        else if(index == nums.length - 1){
            return true;
        }

        if(Memory[index] != 0){
            return Memory[index] == 1;
        }

        boolean res = false;
        for (int i = nums[index]; i >= 1; i--) {
            res |= recursive(index + i, nums);
        }
        Memory[index] = (byte) ((res == true) ? 1 : -1);
        return res;
    }


}
