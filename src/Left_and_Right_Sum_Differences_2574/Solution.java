package Left_and_Right_Sum_Differences_2574;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3})));

    }


    public static int[] leftRightDifference(int[] nums) {

        int rightSum = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            rightSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int nextLeftSum = leftSum + nums[i];
            int nextRightSum = rightSum - nums[i + 1];
            nums[i] = Math.abs(rightSum - leftSum);
            leftSum = nextLeftSum;
            rightSum = nextRightSum;
        }
        nums[nums.length-1] = leftSum;
        return nums;
    }

}
