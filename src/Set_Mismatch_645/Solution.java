package Set_Mismatch_645;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{3, 2, 2})));

    }

    public static int[] findErrorNums(int[] nums) {

        int [] correct = new int[nums.length+1];

        int duplicated = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(correct[num] != 0){
                duplicated = num;
            }
            correct[num] = num;
        }

        int missing = 0;
        for (int i = 1; i < correct.length; i++) {
            if(correct[i] == 0){
                missing = i;
            }
        }

        return new int[]{duplicated, missing};
    }



}
