package Merge_Two_2D_Arrays_by_Summing_Values_2570;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {


        int [][] num1 = new int [][]{{1,2},{2,3},{4,5}};
        int [][] num2 = new int [][]{{1,4},{3,2},{4,1}};

        mergeArrays(num1,num2);


        int [][] num3 = new int [][]{{2,4},{3,6},{5,5}};
        int [][] num4 = new int [][]{{1,3},{4,3}};

        mergeArrays(num3,num4);

    }



    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        HashSet<Integer> idCounts = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            idCounts.add(nums1[i][0]);
        }
        for (int i = 0; i < nums2.length; i++) {
            idCounts.add(nums2[i][0]);
        }

        int [][] result = new int[idCounts.size()][2];

        int index = 0;
        int i1 = 0;
        int i2 = 0;

        while (i1 < nums1.length || i2 < nums2.length){

            int id1 = Integer.MAX_VALUE;
            int value1 = 0;

            if(i1 < nums1.length){
                id1 = nums1[i1][0];
                value1 = nums1[i1][1];
            }

            int id2 = Integer.MAX_VALUE;
            int value2 = 0;

            if(i2 < nums2.length){
                id2 = nums2[i2][0];
                value2 = nums2[i2][1];
            }

            if(id1 == id2){
                result[index][0] = id1;
                result[index][1] = value1 + value2;
                i1++;
                i2++;
            }else if(id1 < id2){
                result[index][0] = id1;
                result[index][1] = value1;
                i1++;
            }else{
                result[index][0] = id2;
                result[index][1] = value2;
                i2++;
            }

            index++;
        }


        return result;
    }



}
