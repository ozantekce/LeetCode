package Minimum_Common_Value_2540;

import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

    }


    public static int getCommon(int[] nums1, int[] nums2) {

        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length){

            int num1 = nums1[p1];
            int num2 = nums2[p2];

            if(num1 == num2){
                return num1;
            }else if(num1 < num2){
                p1++;
            }else{
                p2++;
            }

        }


        return -1;
    }

}
