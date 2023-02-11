package Maximum_Product_Subarray_152;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2,3,-4}));

    }


    public static int maxProduct(int[] nums) {

        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul*=nums[i];
        }
        if(mul>0){
            return mul;
        }

        return maxSubarray(nums,0,nums.length-1);
    }


    public static int maxSubarray(int nums[],int f,int l){

        if(f>=l){
            return nums[f];
        }
        int m = (f+l)/2;

        int L = maxSubarray(nums, f, m);
        int R = maxSubarray(nums, m+1, l);
        int C = maxCrossSubarray(nums, f, m, l);
        //System.out.println("L:"+L+" C:"+ C +" R:"+R);
        return Math.max(C, Math.max(R, L));

    }


    public static int maxCrossSubarray(int nums[],int f,int m,int l){

        int leftMax=Integer.MIN_VALUE;
        int leftMin=Integer.MAX_VALUE;

        int rightMax=Integer.MIN_VALUE;
        int rightMin=Integer.MAX_VALUE;

        // max pos
        // min neg

        int currentMul=1;

        for (int i = m; i >= f; i--) {
            currentMul*=nums[i];
            if(currentMul>leftMax){
                leftMax = currentMul;
            }
            if(currentMul<leftMin){
                leftMin = currentMul;
            }

        }

        currentMul = 1;
        for (int i = m+1; i <= l; i++) {
            currentMul*=nums[i];
            if(currentMul>rightMax){
                rightMax = currentMul;
            }
            if(currentMul<rightMin){
                rightMin = currentMul;
            }
        }

        if (leftMax == Integer.MIN_VALUE) {
            leftMax =0;
        }
        if (rightMax == Integer.MIN_VALUE) {
            rightMax =0;
        }

        if (leftMin == Integer.MAX_VALUE) {
            leftMin =0;
        }
        if (rightMin == Integer.MAX_VALUE) {
            rightMin =0;
        }

        return Math.max((rightMax*leftMax),(rightMin*leftMin));

    }


}
