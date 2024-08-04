package Range_Sum_of_Sorted_Subarray_Sums_1508;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(rangeSum(new int[]{1,2,3,4},4,1,5));
        //System.out.println(rangeSum(new int[]{1,2,3,4},4,3,4));
        //System.out.println(rangeSum(new int[]{1,2,3,4},4,1,10));

    }


    public static int rangeSum(int[] nums, int n, int left, int right) {

        int maxSum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < n; i++) {
            maxSum += nums[i];
            minSum = Math.min(minSum, nums[i]);
        }

        int [] countingSort = new int[maxSum + 1];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                countingSort[sum]++;
            }
        }

        long res = 0;
        int k = 0;
        for (int i = minSum; i <= maxSum; i++) {
            if(countingSort[i] != 0){
                for (int j = 0; j < countingSort[i]; j++) {
                    k++;
                    if(k >= left) res += i;
                    if(k >= right){
                        return (int)(res % 1000000007);
                    }
                }
            }
        }

        return 0;
    }

}
