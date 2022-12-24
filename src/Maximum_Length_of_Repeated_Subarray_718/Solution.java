package Maximum_Length_of_Repeated_Subarray_718;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public static void main(String[] args) {

        int [] nums1 = {1,2,3,2,1};
        int [] nums2 = {3,2,1,4,7};
        System.out.println(findLength(nums1,nums2));

    }

    public static int findLength(int[] nums1, int[] nums2) {

        int DP[][]  = new int[nums1.length+1][nums2.length+1];

        int max = 0;
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i]==nums2[j]){
                    DP[i+1][j+1] = DP[i][j]+1;
                    max = Math.max(DP[i+1][j+1],max);
                }
            }
        }

        return max;
    }


}
