package Squares_of_a_Sorted_Array_977;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5,-3,-2,-1})));

    }



    public static int[] sortedSquares(int[] nums) {

        int p0 = 0;
        int p1 = nums.length-1;

        int [] result = new int[nums.length];

        int i = nums.length-1;
        while (p0<=p1){

            int num0 = nums[p0];
            int num1 = nums[p1];

            int sqr0 = num0 * num0;
            int sqr1 = num1 * num1;

            if(sqr1 > sqr0){
                result[i--] = sqr1;
                p1--;
            }else{
                result[i--] = sqr0;
                p0++;
            }

        }


        return result;
    }


}
