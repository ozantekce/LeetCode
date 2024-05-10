package How_Many_Numbers_Are_Smaller_Than_the_Current_Number_1365;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));

    }
    
    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int [] counter = new int[101];
        int [] cumulative = new int[101];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            cumulative[i] += counter[i-1] + cumulative[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = cumulative[nums[i]];
        }

        
        return nums;
    }
    
    
}
