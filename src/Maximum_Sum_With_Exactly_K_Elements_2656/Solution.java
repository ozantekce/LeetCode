package Maximum_Sum_With_Exactly_K_Elements_2656;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maximizeSum(new int[]{1,2,3,4,5},3));
        System.out.println(maximizeSum(new int[]{5,5,5},2));

    }


    public static int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return k * max + ((k - 1) * k)/2;
    }

}
