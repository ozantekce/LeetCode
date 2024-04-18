package Jewels_and_Stones_771;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(numJewelsInStones("aA","aAAbbbb"));
        System.out.println(numJewelsInStones("z","ZZ"));

    }


    public static int numJewelsInStones(String jewels, String stones) {

        int res = 0;
        byte[] bytes = new byte[58];

        for (int i = 0; i < stones.length(); i++) {
            bytes[stones.charAt(i) - 'A']++;
        }
        for (int i = 0; i < jewels.length(); i++) {
            int index = jewels.charAt(i) - 'A';
            res += bytes[index];
            bytes[index] = 0;
        }


        return res;
    }


}
