package Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box_1769;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(minOperations("110")));
        System.out.println(Arrays.toString(minOperations("001011")));

    }

    public static int[] minOperations(String boxes) {

        int [] res = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            char c = boxes.charAt(i);
            if(c == '1'){
                for (int j = 0; j < res.length; j++) {
                    int diff = Math.abs(i - j);
                    res[j] += diff;
                }
            }
        }

        return res;
    }

}
