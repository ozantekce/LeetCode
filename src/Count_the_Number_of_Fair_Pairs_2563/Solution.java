package Count_the_Number_of_Fair_Pairs_2563;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(countFairPairs(new int[]{0,1,7,4,4,5},3,6));
        System.out.println(countFairPairs(new int[]{0,0,0,0,0,0},0,0));
        System.out.println(countFairPairs(new int[]{1,7,9,2,5},11,11));
        System.out.println(countFairPairs(new int[]{6,5,10,2,4,9,0,7},20,20));
        System.out.println(countFairPairs(new int[]{-1,0},1,1));

    }

    // 1,2,5,7,9
    public static long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        long result = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int current = nums[i];
            int newLower = lower - current;
            int newUpper = upper - current;

            if (newLower > nums[nums.length - 1] ||
                    newUpper < nums[0] ||
                    newUpper < newLower) {
                continue;
            }

            int lowerIndex = binarySearch(i+1, nums.length, newLower, nums, true);
            int upperIndex = binarySearch(i+1, nums.length, newUpper, nums, false);


            int count = upperIndex - lowerIndex + 1;

            if (lowerIndex <= i && i <= upperIndex) {
                count--;
            }

            if (count > 0) {
                result += count;
            }

        }
        return result;
    }

    private static int binarySearch(int start, int end, int target, int[] nums, boolean forLower) {
        int left = start;
        int right = end - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                if (forLower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return forLower ? right + 1 : left - 1;
    }



}
