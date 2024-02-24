package Merge_Two_2D_Arrays_by_Summing_Values_2570;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

    }



    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        TreeMap<Integer,Integer> merged = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            merged.put(nums1[i][0],nums1[i][1]);
        }

        for (int i = 0; i < nums2.length; i++) {
            int sum = merged.getOrDefault(nums2[i][0],0) + nums2[i][1];
            merged.put(nums2[i][0], sum);
        }


        int [][] result = new int[merged.size()][2];

        int i = 0;
        for (Map.Entry<Integer,Integer> pair : merged.entrySet() ) {
            result[i][0] = pair.getKey();
            result[i][1] = pair.getValue();
            i++;
        }

        return  result;
    }

}
