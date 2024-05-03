package Minimum_Sum_of_Mountain_Triplets_I_2908;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minimumSum(new int[]{8,6,1,5,3}));

    }


    public static int minimumSum(int[] nums) {

        int res = Integer.MAX_VALUE;
        for (int mid = 1; mid < nums.length-1; mid++) {

            for (int left = 0; left < mid; left++) {

                for (int right = nums.length-1; right > mid ; right--) {
                    int leftVal = nums[left];
                    int midVal = nums[mid];
                    int rightVal = nums[right];

                    if(midVal > leftVal && midVal > rightVal){
                        res = Math.min(res, (leftVal + midVal + rightVal));
                    }
                }

            }

        }


        return res != Integer.MAX_VALUE ? res : -1;
    }


}
