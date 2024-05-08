package Relative_Ranks_506;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {


    public static void main(String[] args) {

    }



    public static String[] findRelativeRanks(int[] score) {

        Int2 [] int2s = new Int2[score.length];
        for (int i = 0; i < score.length; i++) {
            int2s[i] = new Int2(score[i], i);
        }

        Arrays.sort(int2s);
        String[] res = new String[int2s.length];

        if(res.length > 0){
            res[int2s[0].index] = "Gold Medal";
        }
        if(res.length > 1){
            res[int2s[1].index] = "Silver Medal";
        }
        if(res.length > 2){
            res[int2s[2].index] = "Bronze Medal";
        }

        for (int i = 3; i < int2s.length; i++) {
            Int2 int2 = int2s[i];
            int index = int2.index;
            res[index] = String.valueOf(i+1);
        }

        return res;
    }

    private static class Int2 implements Comparable<Int2>
    {
        public int value;
        public int index;

        public Int2(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Int2 o) {
            return -Integer.compare(value, o.value);
        }
    }


}
