package Subarray_Sums_Divisible_by_K_974;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {



    public static void main(String[] args) {

        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        //System.out.println(subarraysDivByK(new int[]{5}, 9));

    }



    public static int subarraysDivByK(int[] nums, int k) {

        int res = 0;
        int n = nums.length;
        int [] prefSums = new int[n];
        prefSums[0] = (nums[0] % k + k) % k;
        for (int i = 1; i < n; i++) {
            prefSums[i] = prefSums[i-1] + (nums[i] % k) + k;
            prefSums[i] %= k;
        }
        int [] map = new int[k];
        map[0] = 1;
        for (int i = 0; i < n; i++) {
            res += map[prefSums[i]];
            map[prefSums[i]]++;
        }

        return res;

    }


}
