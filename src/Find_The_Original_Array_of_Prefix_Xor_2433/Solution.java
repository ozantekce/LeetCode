package Find_The_Original_Array_of_Prefix_Xor_2433;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findArray(new int[]{5, 2, 0, 3, 1})));
    }


    public static int[] findArray(int[] pref) {

        int[] res = new int[pref.length];
        res[0] = pref[0];
        for (int i = pref.length-1; i > 0; i--) {
            int temp = pref[i] ^ pref[i-1];
            res[i] = temp;
        }

        return res;
    }

}
