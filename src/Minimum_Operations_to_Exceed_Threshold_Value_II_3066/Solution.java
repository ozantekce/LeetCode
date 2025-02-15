package Minimum_Operations_to_Exceed_Threshold_Value_II_3066;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
        System.out.println(minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));

    }

    public static int minOperations(int[] nums, int k) {
        int first0 = 0;
        int size0 = 0;
        int[] array0 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) array0[size0++] = nums[i];
        }
        Arrays.sort(array0, 0, size0);
        int first1 = 0;
        int size1 = 0;
        int[] array1 = new int[size0];

        int res = 0;
        boolean isEmpty0 = first0 >= size0;
        boolean isEmpty1 = true;

        while (!isEmpty0 || !isEmpty1) {
            int x;
            if (!isEmpty0 && !isEmpty1) {
                if (array0[first0] < array1[first1]) x = array0[first0++];
                else x = array1[first1++];
            } else if (!isEmpty0) {
                x = array0[first0++];
            } else {
                x = array1[first1++];
            }

            isEmpty0 = first0 >= size0;
            isEmpty1 = first1 >= size1;

            int y;
            if (!isEmpty0 && !isEmpty1) {
                if (array0[first0] < array1[first1]) y = array0[first0++];
                else y = array1[first1++];
            } else if (!isEmpty0) {
                y = array0[first0++];
            } else if (!isEmpty1) {
                y = array1[first1++];
            } else {
                return res + 1;
            }

            int n = x * 2 + y;
            if (n > 0 && n < k) array1[size1++] = n;
            res++;

            isEmpty0 = first0 >= size0;
            isEmpty1 = first1 >= size1;
        }
        return res;
    }


}
