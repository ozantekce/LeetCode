package Jump_Game_55;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{1,2,3}));

    }



    public static boolean canJump(int[] nums){

        int range = nums[0];
        for (int i = 0; i <= nums.length-1 && range < nums.length - 1 ; i++) {
            if(i > range)
                return false;
            range = Math.max(range, i + nums[i]);
        }

        return true;
    }

}
