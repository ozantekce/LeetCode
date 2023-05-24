package Make_Two_Arrays_Equal_by_Reversing_Subarrays_1460;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canBeEqual(new int[]{1,2,3,4},new int[]{2,4,1,3}));
        System.out.println(canBeEqual(new int[]{3,7,9},new int[]{3,7,11}));

    }


    public static boolean canBeEqual(int[] target, int[] arr) {

        if(target.length!=arr.length)return false;

        int [] map = new int[1001];

        for (int i = 0; i < target.length; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }
        for (int i = 0; i < 1001; i++) {
            if(map[i]!=0)return false;
        }


        return true;
    }

}
