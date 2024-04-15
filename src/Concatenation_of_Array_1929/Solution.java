package Concatenation_of_Array_1929;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 3, 2, 1})));

    }


    public static int[] getConcatenation(int[] nums) {

        int [] res = new int[nums.length*2];

        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i%nums.length];
        }

        return res;
    }

}
