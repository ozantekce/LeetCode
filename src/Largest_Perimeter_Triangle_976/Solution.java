package Largest_Perimeter_Triangle_976;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(largestPerimeter(new int[]{2,1,2}));
        System.out.println(largestPerimeter(new int[]{1,2,1,10}));

    }



    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length-1; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i-1];
            int c = nums[i-2];
            if(a+b>c && a+c>b && b+c>a){
                return a+b+c;
            }
        }

        return 0;
    }

}
