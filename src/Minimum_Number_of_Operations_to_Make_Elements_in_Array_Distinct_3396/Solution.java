package Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct_3396;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(minimumOperations(new int[]{8, 10, 7, 1, 5, 1, 8}));
        //System.out.println(minimumOperations(new int[]{4, 5, 6, 4, 4}));
        //System.out.println(minimumOperations(new int[]{3, 7, 12, 12, 3, 14, 1, 1}));

    }

    public static int minimumOperations(int[] nums) {
        int[] map = new int[101];
        Arrays.fill(map, -1);
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map[num] != -1) {
                startIndex = Math.max(map[num] + 1, startIndex);
            }
            map[num] = i;
        }
        return startIndex / 3 + (startIndex % 3 > 0 ? 1 : 0);
    }


}
