package Merge_Two_2D_Arrays_by_Summing_Values_2570;

import java.util.*;

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

        List<int[]> resultList = new ArrayList<>(nums1.length + nums2.length);
        int i1 = 0;
        int i2 = 0;

        while (i1 < nums1.length && i2 < nums2.length){

            int id1 = nums1[i1][0];
            int value1 = nums1[i1][1];

            int id2 = nums2[i2][0];
            int value2 = nums2[i2][1];

            if(id1 == id2){
                resultList.add(new int []{id1, value1+value2});
                i1++;
                i2++;
            }else if(id1 < id2){
                resultList.add(nums1[i1]);
                i1++;
            }else{
                resultList.add(nums2[i2]);
                i2++;
            }

        }

        if(i1 == nums1.length){
            while (i2 < nums2.length){
                resultList.add(nums2[i2]);
                i2++;
            }
        }else{
            while (i1 < nums1.length){
                resultList.add(nums1[i1]);
                i1++;
            }
        }

        int [][] result = resultList.toArray(new int[resultList.size()][]);

        return result;
    }




}
