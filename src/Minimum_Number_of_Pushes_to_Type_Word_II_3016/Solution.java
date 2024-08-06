package Minimum_Number_of_Pushes_to_Type_Word_II_3016;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));

    }


    public static int minimumPushes(String word) {

        int [] freqMap = new int[26];

        for (int i = 0; i < word.length(); i++) {
            freqMap[word.charAt(i)-'a']++;
        }

        Arrays.sort(freqMap);

        int totalCost = 0;
        int add = 1;
        int seq = 0;

        for (int i = 25; i >= 0; i--) {
            int count = freqMap[i];
            if(count == 0)
                break;
            totalCost += add * count;
            seq++;
            if(seq == 8){
                seq = 0;
                add++;
            }
        }

        return totalCost;
    }


}
