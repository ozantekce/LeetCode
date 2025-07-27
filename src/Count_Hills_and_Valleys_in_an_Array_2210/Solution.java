package Count_Hills_and_Valleys_in_an_Array_2210;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(countHillValley(new int[]{6, 6, 5, 5, 4, 1}));

    }


    public static int countHillValley(int[] nums) {

        int[] rights = new int[nums.length];
        Arrays.fill(rights, -1);
        int from = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[from] != nums[i]) {
                Arrays.fill(rights, from, i, nums[i]);
                from = i;
            }
        }

        int[] lefts = new int[nums.length];
        Arrays.fill(lefts, -1);
        from = nums.length - 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[from] != nums[i]) {
                Arrays.fill(lefts, i + 1, from + 1, nums[i]);
                from = i;
            }
        }


        int beforeType = 0;
        int counter = 0;
        for (int i = 1; i < nums.length - 1; i++) {

            if (lefts[i] == -1 || rights[i] == -1) {
                beforeType = 0;
                continue;
            }

            if (nums[i] > lefts[i] && nums[i] > rights[i]) {
                if (beforeType != 1) counter++;
                beforeType = 1;
            } else if (nums[i] < lefts[i] && nums[i] < rights[i]) {
                if (beforeType != 2) counter++;
                beforeType = 2;
            } else {
                beforeType = 0;
            }

        }

        return counter;
    }


}
