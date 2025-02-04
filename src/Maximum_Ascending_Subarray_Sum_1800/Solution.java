package Maximum_Ascending_Subarray_Sum_1800;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));

    }


    public static int maxAscendingSum(int[] nums) {

        int sum = nums[0];
        int res = sum;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }

        return res;
    }

}
