package Single_Number_III_260;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(singleNumber(new int[]{1, 5, 1, 3, 2, 2})));
        //System.out.println(Arrays.toString(singleNumber(new int[]{-1,0})));
        //System.out.println(Arrays.toString(singleNumber(new int[]{0,1})));


    }

    // 101  -> 5
    // 011  -> 3

    // 110  -> 6

    public static int[] singleNumber(int[] nums) {

        int set = 0;
        for (int i = 0; i < nums.length; i++) {
            set ^= nums[i];
        }

        int mask = 1;
        while ((set & mask) == 0){
            mask = mask << 1;
        }

        //System.out.println(mask+" "+ set);

        int set0 = 0;
        int set1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & mask) == 0){
                set0 ^= nums[i];
            }else{
                set1 ^= nums[i];
            }
        }

        return new int[]{set0, set1};
    }

}
