package Largest_Number_At_Least_Twice_of_Others_747;

public class Solution {





    public int dominantIndex(int[] nums) {


        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i!=index){
                if(nums[i]<<1>max){
                    return -1;
                }
            }
        }



        return index;
    }


}
