package Partition_Array_According_to_Given_Pivot_2161;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int leftSize = 0;
        int midSize = 0;
        int rightSize = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < pivot) {
                left[leftSize++] = num;
            } else if (num == pivot) {
                midSize++;
            } else {
                right[rightSize++] = num;
            }
        }

        int midPointer = leftSize;
        int rightPointer = leftSize + midSize;

        System.arraycopy(left, 0, nums, 0, leftSize);
        Arrays.fill(nums, midPointer, midPointer + midSize, pivot);
        System.arraycopy(right, 0, nums, rightPointer, rightSize);

        return nums;
    }

}
