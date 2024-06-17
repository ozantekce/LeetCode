package Patching_Array_330;

import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minPatches(new int[]{1,3},6));
        System.out.println(minPatches(new int[]{1,5,10},20));
        //System.out.println(minPatches(new int[]{1, 2, 3, 9},20));
        System.out.println(minPatches(new int[]{1,2,2},5));
        System.out.println(minPatches(new int[]{1,2,31,33},2147483647));
        System.out.println(minPatches(new int[]{1,2,32},2147483647));
        //System.out.println(minPatches(new int[]{1,2,32},50));

    }



    public static int minPatches(int[] nums, int n) {

        int res = 0;
        long max = 0;

        for (int i = 0; i < nums.length && max < n; i++) {

            while (nums[i] > max + 1 && max < n) {
                max += max + 1;
                res++;
            }
            if (max >= n)
                break;

            max += nums[i];
        }

        for (long i = max+1; i <= n;) {
            res++;
            i += i + 1;
        }

        return res;
    }



}
