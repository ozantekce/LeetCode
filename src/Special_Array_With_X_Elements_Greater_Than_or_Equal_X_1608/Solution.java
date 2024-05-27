package Special_Array_With_X_Elements_Greater_Than_or_Equal_X_1608;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }


    public static int specialArray(int[] nums) {

        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }

        int [] counter = new int[maxVal+1];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        for (int i = maxVal-1; i >= 0; i--) {
            counter[i] += counter[i+1];
        }

        for (int i = 0; i <= maxVal; i++) {
            if(counter[i] == i)
                return i;
            else if(counter[i] < i)
                return -1;
        }

        return -1;
    }


}
