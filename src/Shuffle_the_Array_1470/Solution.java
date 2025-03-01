package Shuffle_the_Array_1470;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));

    }


    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int i = 0;
        for (int p0 = 0, p1 = n; p0 < n; p0++, p1++) {
            res[i++] = nums[p0];
            res[i++] = nums[p1];
        }
        return res;
    }

}
