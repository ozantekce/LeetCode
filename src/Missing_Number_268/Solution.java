package Missing_Number_268;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));

    }


    public static int missingNumber(int[] nums) {
        int rst = nums.length;
        for (int i = 0; i < nums.length; i++) {
            rst^=i^nums[i];
        }
        return rst;
    }

}
