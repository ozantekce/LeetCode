package FindtheDistinctDifferenceArray_2670;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(distinctDifferenceArray(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(distinctDifferenceArray(new int[]{3,2,3,4,2})));

    }


    public static int[] distinctDifferenceArray(int[] nums) {

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int val = 0;
            boolean[] set = new boolean[51];
            for (int j = 0; j <= i; j++) {
                if(!set[nums[j]]){
                    val++;
                    set[nums[j]] = true;
                }
            }
            set = new boolean[51];
            for (int j = i+1; j < nums.length; j++) {
                if(!set[nums[j]]){
                    val--;
                    set[nums[j]] = true;
                }
            }

            res[i] = val;
        }

        return res;
    }


}
