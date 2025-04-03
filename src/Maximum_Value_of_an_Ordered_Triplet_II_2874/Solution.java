package Maximum_Value_of_an_Ordered_Triplet_II_2874;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(maximumTripletValue(new int[]{1, 2, 3}));

    }


    public static long maximumTripletValue(int[] nums) {

        int[] temp = new int[nums.length];

        int prefixMax = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            prefixMax = Math.max(nums[i - 1], prefixMax);
            temp[i] = prefixMax - nums[i];
        }

        long res = 0;
        int suffixMax = 0;
        for (int i = nums.length - 2; i >= 1; i--) {
            suffixMax = Math.max(nums[i + 1], suffixMax);
            res = Math.max(res, (long) temp[i] * suffixMax);
        }

        return res;
    }

}
