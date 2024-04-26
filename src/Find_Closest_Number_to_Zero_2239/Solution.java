package Find_Closest_Number_to_Zero_2239;

public class Solution {

    public static void main(String[] args) {

        System.out.println(findClosestNumber(new int[]{-4,-2,1,4,8}));

    }


    public static int findClosestNumber(int[] nums) {

        int res = Integer.MAX_VALUE;
        boolean negative = false;
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (v < res || (v == res && negative)){
                res = v;
                negative = nums[i] < 0;
            }
        }

        return negative ? -res : res;
    }

}
