package Minimum_Distance_to_the_Target_Element_1848;

public class Solution {


    public static void main(String[] args) {

        System.out.println(getMinDistance(new int[]{1,2,3,4,5},5,3));

    }

    public static int getMinDistance(int[] nums, int target, int start) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==target){
                int val = i-start;
                if(i<start){
                    val*=-1;
                }
                min = Math.min(min,val);
            }

        }


        return min;
    }

}
