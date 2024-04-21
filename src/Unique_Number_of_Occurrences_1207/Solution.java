package Unique_Number_of_Occurrences_1207;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(uniqueOccurrences(new int[]{1,2}));
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));

    }


    public static boolean uniqueOccurrences(int[] arr) {

        int[] counter = new int[2001];

        for (int i = 0; i < arr.length; i++) {
            counter[arr[i] + 1000]++;
        }

        boolean [] set = new boolean[1001];

        for (int i = 0; i < arr.length; i++) {
            int normalized = arr[i] + 1000;
            int count = counter[normalized];
            counter[normalized] = 0;
            if(count != 0){
                if(!set[count])
                    set[count] = true;
                else
                    return false;
            }
        }

        return true;
    }

}
