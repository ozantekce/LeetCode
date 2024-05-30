package Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR_1442;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countTriplets(new int[]{2,3,1,6,7}));
        System.out.println(countTriplets(new int[]{1,1,1,1,1}));
        System.out.println(countTriplets(new int[]{2,3}));

    }



    public static int countTriplets(int[] arr) {

        int [] pref = new int[arr.length];
        pref[0] = arr[0];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            pref[i] = arr[i] ^ (i > 0 ? pref[i-1] : 0);
            for (int j = 0; j < i; j++) {
                int val0 = pref[i] ^ (j > 0 ? pref[j-1] : 0);
                if(val0 == 0){
                    res += i - j;
                }
            }
        }

        return res;
    }

}
