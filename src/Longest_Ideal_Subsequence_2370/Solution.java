package Longest_Ideal_Subsequence_2370;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(longestIdealString("acfgbd",2));     // 4
        //System.out.println(longestIdealString("abcd",3));       // 4
        //System.out.println(longestIdealString("jxhwaysa",14));  // 5
        System.out.println(longestIdealString("eduktdb",15));   // 5
        //System.out.println(longestIdealString("pvjcci",4));     // 2

    }


    public static int longestIdealString(String s, int k) {

        int n = s.length();
        int[] memory = new int[n];
        int[] map = new int[26];

        memory[n-1] = 1;
        map[s.charAt(n-1) - 'a'] = n-1;

        int res = 1;
        for (int i = 1; i < n; i++) {
            int firstIndex = n-1-i;
            int val;
            int max = 0;
            char c0 = s.charAt(firstIndex);

            for (int j = 0; j < 26; j++) {
                int diff = Math.abs(c0 - ( j + 'a'));
                if(diff <= k){
                    int index = map[j];
                    if(index > 0){
                        int temp = memory[index];
                        max = Math.max(max, temp);
                    }
                }
            }
            memory[firstIndex] = max + 1;
            val = max + 1;
            map[c0-'a'] = firstIndex;
            res = Math.max(val, res);
        }

        return res;
    }


/*
    public static int find(String s, int k, int first, int last){

        if(memory[first] != 0){
            return memory[first];
        }

        int max = 0;
        char c0 = s.charAt(first);
        for (int i = first+1; i <= last; i++) {
            char c1 = s.charAt(i);
            int diff = Math.abs(c0 - c1);
            if(diff <= k){
                int val = memory[i];
                max = Math.max(max, val);
            }
        }

        memory[first] = max + 1;
        return max + 1;
    }
*/
}
