package Minimum_Operations_to_Make_Array_Values_Equal_to_K_3375;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{5, 2, 5, 4, 5}, 2));
        System.out.println(minOperations(new int[]{2, 1, 2}, 2));
        System.out.println(minOperations(new int[]{9, 7, 5, 3}, 1));
        System.out.println(minOperations(new int[]{1}, 1));


    }


    public static int minOperations(int[] nums, int k) {

        int[] counter = new int[101];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
            if (nums[i] < k) {
                return -1;
            }
        }

        int res = 0;
        int high = -1;
        for (int i = 100; i >= k ; i--) {
            if (counter[i] != 0 || i == k) {
                if (high != -1) {
                    res++;
                }
                high = i;
            }
        }
        return res;
    }


}
