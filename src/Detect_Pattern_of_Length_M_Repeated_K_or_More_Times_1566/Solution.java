package Detect_Pattern_of_Length_M_Repeated_K_or_More_Times_1566;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(containsPattern(new int[]{1,2,4,4,4,4}, 1, 3));
        //System.out.println(containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2, 2));
        //System.out.println(containsPattern(new int[]{1,2,1,2,1,3}, 2, 3));
        //System.out.println(containsPattern(new int[]{2,2,2,2}, 2, 3));
        //System.out.println(containsPattern(new int[]{1,2,3,1,2}, 2, 2));
        System.out.println(containsPattern(new int[]{2,2,1,2,2,1,1,1,2,1}, 2, 2));
    }

    public static boolean containsPattern(int[] arr, int m, int k) {

        for (int i = 0; i < arr.length - m; i++) {
            int f = 0;
            int c_k = k - 1;
            for (int j = i + m; j < arr.length; j++) {
                if(arr[j] != arr[i + f]){
                    break;
                }
                f++;
                if(f == m){
                    f = 0;
                    c_k--;
                    if(c_k == 0){
                        return true;
                    }
                }

            }

        }

        return false;
    }


}
