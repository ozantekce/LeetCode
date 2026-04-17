package Minimum_Absolute_Distance_Between_Mirror_Pairs_3761;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        System.out.println(reverse(120));

        //System.out.println(minMirrorPairDistance(new int[]{12, 21, 45, 33, 54}));
        //System.out.println(minMirrorPairDistance(new int[]{120, 21}));
        //System.out.println(minMirrorPairDistance(new int[]{21, 120}));

    }

    public static int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);

            if (indexMap.containsKey(nums[i])) {
                int dis = i - indexMap.get(nums[i]);
                result = Math.min(result, dis);
            }

            indexMap.put(rev, i);
        }


        return result != Integer.MAX_VALUE ? result : -1;
    }


    public static int reverse(int value) {
        int res = 0;
        while (value > 0) {
            res *= 10;
            int d = value % 10;
            res += d;
            value /= 10;
        }
        return res;
    }

}
