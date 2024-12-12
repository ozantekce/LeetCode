package Sort_an_Array_912;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int slider = min > 0 ? 0 : -min;
        int l = 1 + max + slider;

        int[] counter = new int[l];

        for (int i = 0; i < nums.length; i++) {
            int slidedValue = slider + nums[i];
            counter[slidedValue]++;
        }

        int k = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                nums[k++] = i - slider;
            }
        }

        return nums;
    }

}
