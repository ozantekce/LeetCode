package Single_Number_136;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    //11224

    public static int singleNumber(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.add(nums[i])){
                result += nums[i];
            }else{
                result -= nums[i];
            }

        }
        return result;
    }


}
