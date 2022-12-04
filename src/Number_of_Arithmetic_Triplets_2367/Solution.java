package Number_of_Arithmetic_Triplets_2367;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(arithmeticTriplets(new int[]{0,1,4,6,7,10},3));

    }

    public static int arithmeticTriplets(int[] nums, int diff) {

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            int target = nums[i]+diff;
            int targetIndex = Arrays.binarySearch(nums,i+1,nums.length,target);
            if(targetIndex>=0){

                target = nums[targetIndex]+diff;
                targetIndex = Arrays.binarySearch(nums,targetIndex+1,nums.length,target);
                if(targetIndex>=0){
                    counter++;
                }
            }

        }


        return counter;
    }


}
