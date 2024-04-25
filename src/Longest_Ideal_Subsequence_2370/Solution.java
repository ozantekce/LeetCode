package Longest_Ideal_Subsequence_2370;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(longestIdealString("acfgbd",2));     // 4
        //System.out.println(longestIdealString("abcd",3));       // 4
        //System.out.println(longestIdealString("jxhwaysa",14));  // 5
        System.out.println(longestIdealString("eduktdb",15));   // 5
        //System.out.println(longestIdealString("pvjcci",4));     // 2

    }


    public static int longestIdealString(String s, int k) {

        int n = s.length();
        int[] map = new int[26];

        map[s.charAt(n-1) - 'a'] = 1;
        int res = 1;
        for (int i = n-2; i >= 0; i--) {
            int max = 0;
            int order = s.charAt(i) - 'a';
            int start = Math.max(0, order-k);
            int end = Math.min(order+k, 25);
            for (int j = start; j <= end; j++) {
                max = Math.max(max, map[j]);
            }
            map[order] = max + 1;
            res = Math.max(max + 1, res);
        }
        return res;
    }

}
