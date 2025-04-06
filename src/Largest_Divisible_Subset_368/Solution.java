package Largest_Divisible_Subset_368;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        //System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
        //System.out.println(largestDivisibleSubset(new int[]{1, 2, 3, 4, 5, 6, 130, 8, 9, 10, 135, 12, 140, 14, 15, 16, 145, 18, 20, 21, 22, 150, 24, 25, 26, 27, 28, 155, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 65, 66, 69, 70, 72, 75, 78, 80, 81, 84, 85, 87, 90, 93, 95, 100, 105, 110, 115, 120, 125}));
        //System.out.println(largestDivisibleSubset(new int[]{3,4,16,8}));
        //System.out.println(largestDivisibleSubset(new int[]{2, 3, 4, 8}) + " " + largestDivisibleSubsetOld(new int[]{2, 3, 4, 8}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Memory = new List[nums.length];
        return find(0, 0, nums);
    }

    private static List<Integer>[] Memory;

    public static List<Integer> find(int startIndex, int max, int[] nums) {

        if (startIndex >= nums.length) return null;

        if (Memory[startIndex] != null) return Memory[startIndex];

        List<Integer> result = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];

            boolean canInclude = max == 0 || max % num == 0 || num % max == 0;

            if (canInclude) {

                int newMax = num;
                if (max > num) newMax = max;

                List<Integer> subResult = find(i + 1, newMax, nums);

                int newSize = (subResult != null ? subResult.size() : 0) + 1;

                if (newSize > result.size()) {
                    result.clear();
                    result.add(num);
                    if (subResult != null) result.addAll(subResult);
                }
            }

        }

        Memory[startIndex] = result;
        return result;
    }

}
