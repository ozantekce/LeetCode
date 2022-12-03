package Maximum_Product_of_Three_Numbers_628;


import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maximumProduct(new int[]{-100,-98,-1,2,3,4}));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        max = Math.max(max,nums[0]*nums[1]*nums[nums.length-1]);
        return max;
    }


}
