package The_Number_of_Beautiful_Subsets_2597;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(beautifulSubsets(new int[]{2,4,6},2));

    }


    public static int beautifulSubsets(int[] nums, int k) {
        
        return recursive(nums,new int[1001+k]  ,0, k);
    }


    private static int recursive(int[] nums, int[] map, int i, int k){

        if(i>=nums.length)
            return 0;

        int res = 0;
        for (; i < nums.length; i++) {
            map[nums[i]]++;
            boolean isbeautiful = map[nums[i]+k] == 0 &&
                    (nums[i] - k < 0 || map[nums[i]-k] == 0);

            if(isbeautiful){
                res++;
                res += recursive(nums, map, i+1, k);
            }
            map[nums[i]]--;
        }
        return res;
    }

    


}
