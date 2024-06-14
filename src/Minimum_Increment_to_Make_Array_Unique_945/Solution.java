package Minimum_Increment_to_Make_Array_Unique_945;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minIncrementForUnique(new int[]{1,2,2}));
        System.out.println(minIncrementForUnique(new int[]{3,2,1,2,1,7}));
        System.out.println(minIncrementForUnique(new int[]{1,0}));
        System.out.println(minIncrementForUnique(new int[]{0,0}));
        System.out.println(minIncrementForUnique(new int[]{0,0,0}));

    }



    public static int minIncrementForUnique(int[] nums) {

        countingSort(nums);
        int [] array = new int[nums.length];
        int [] mins = new int[nums.length+1];

        array[0] = nums[0];
        mins[1] = nums[0]+1;
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            array[i] = Math.max(nums[i], mins[i]);
            mins[i+1] = array[i] + 1;
            res += (array[i] - nums[i]);
        }

        return res;
    }

    private static void countingSort(int [] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] counter = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        int k = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < counter[i]; j++) {
                nums[k++] = i;
            }
        }

    }


}
