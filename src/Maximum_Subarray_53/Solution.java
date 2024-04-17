package Maximum_Subarray_53;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));

    }

    // Kadane’s Algorithm
    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int max = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], nums[i] + max);
            if(max > res){
                res = max;
            }
        }

        return res;
    }


    public static int maxSubarray(int A[], int l, int r){
        if(l==r){
            return A[l];
        }
        int M = (l + r) / 2;
        int L = maxSubarray(A, l, M);
        int R = maxSubarray(A,M+1, r);
        int C = maxCrossSubarray(A, l, M, r);
        return Math.max(C, Math.max(R, L));
    }



    public static int maxCrossSubarray(int A[], int l, int m, int r){

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int currentSum = 0;
        for (int i = m; i >= l; i--) {
            currentSum += A[i];
            if(currentSum > leftMax){
                leftMax = currentSum;
            }
        }

        currentSum = 0;
        for (int i = m+1; i <= r; i++) {
            currentSum += A[i];
            if(currentSum > rightMax){
                rightMax = currentSum;
            }
        }

        if (leftMax == Integer.MIN_VALUE) {
            leftMax = 0;
        }
        if (rightMax == Integer.MIN_VALUE) {
            rightMax = 0;
        }


        return rightMax + leftMax;

    }

}
