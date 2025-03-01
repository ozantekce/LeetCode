package Apply_Operations_to_an_Array_2460;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0, 1})));
    }


    public static int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
                if (nums[i] != 0) res[j++] = nums[i];
                i++;
            }else{
                if (nums[i] != 0) res[j++] = nums[i];
            }
        }
        if (nums[nums.length - 1] != 0) {
            res[j] = nums[nums.length - 1];
        }
        return res;
    }

}
