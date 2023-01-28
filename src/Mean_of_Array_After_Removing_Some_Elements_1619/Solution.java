package Mean_of_Array_After_Removing_Some_Elements_1619;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}));

    }

    public static double trimMean(int[] arr) {

        Arrays.sort(arr);

        int pass = (int) (arr.length/100d*5);
        int sum = 0;
        for (int i = pass; i < arr.length-pass; i++) {
            sum += arr[i];
        }
        return sum/(arr.length-2d*pass);
    }


}
