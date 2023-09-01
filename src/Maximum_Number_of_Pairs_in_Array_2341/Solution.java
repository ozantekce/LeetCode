package Maximum_Number_of_Pairs_in_Array_2341;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(numberOfPairs(new int[]{1,3,2,1,3,2,2})));
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1,1})));
        System.out.println(Arrays.toString(numberOfPairs(new int[]{0})));

    }



    public static int[] numberOfPairs(int[] nums) {

        int [] result = new int[2];

        int [] counter = new int[101];

        for (int num : nums) counter[num]++;

        for (int count : counter) {
            result[0] += count / 2;
            result[1] += count % 2;
        }

        return result;
    }

}
