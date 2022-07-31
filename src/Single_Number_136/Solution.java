package Single_Number_136;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2,2,1}));
    }

    //11224

    public static int singleNumber(int[] nums) {

        Arrays.sort(nums);
        int n1,n2;
        for (int i = 0; i < nums.length; i+=2) {
            n1 = nums[i];
            if(i+1==nums.length){
                return n1;
            }
            n2 = nums[i+1];
            if(n1!=n2)
                return n1;
        }

        return -1;
    }



}
