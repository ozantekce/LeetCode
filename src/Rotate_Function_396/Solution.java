package Rotate_Function_396;


import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        Rotate_Function_396.Solution solution = new Rotate_Function_396.Solution();
        long start = System.nanoTime();

        System.out.println(solution.maxRotateFunction(new int[]{1,2,3,4,5,6,7,8,9,10}));

        System.out.println((System.nanoTime()-start)/100000.0);
    }

    public int maxRotateFunction(int[] nums) {

        int length = nums.length;
        int f=0;
        int sum =0;
        for (int i = 0; i < length; i++) {
            f += nums[i]*i;
            sum += nums[i];
        }

        // f[0] = f
        // f[1] = f[0] + (-3 N[3] + N[0] + N[1] + N[2] ) -> f[0] + sum(N[...]) - 4 N[3]
        // f[2] = f[1] + (-3 N[2] + N[3] + N[0] + N[1] ) -> f[1] + sum(N[...]) - 4 N[2]
        // f[3] = f[2] + (-3 N[1] + N[2] + N[3] + N[0] ) -> f[2] + sum(N[...]) - 4 N[1]

        int max = Integer.MIN_VALUE;
        int lastF = f;
        for (int i = 1; i < length+1; i++) {
            f = lastF + sum - length * nums[length-i];
            //System.out.println(length-i+ " "+ f);
            if(f>max)
                max =f;
            lastF = f;
        }

        return max;
    }





}
