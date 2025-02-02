package Check_if_Array_Is_Sorted_and_Rotated_1752;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(check(new int[]{2, 1, 3, 4}));
        System.out.println(check(new int[]{1, 2, 3}));

    }

    public static boolean check(int[] nums) {
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                offset = i;
                break;
            }
        }
        return isSorted(offset, nums);
    }

    public static boolean isSorted(int offset, int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index0 = (i + offset) % n;
            int index1 = (i + 1 + offset) % n;
            int val0 = nums[index0];
            int val1 = nums[index1];
            if (val0 > val1)
                return false;
        }
        return true;
    }

}
