package Decompress_Run_Length_Encoded_List_1313;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 1, 2, 3})));

    }



    public static int[] decompressRLElist(int[] nums) {

        int size = 0;

        for (int i = 0; i < nums.length; i+=2) {
            size += nums[i];
        }

        int[] res = new int[size];
        int j = 0;
        for (int i = 1; i < nums.length; i+=2) {
            Arrays.fill(res, j, j + nums[i-1],nums[i]);
            j += nums[i-1];
        }

        return res;
    }

}
