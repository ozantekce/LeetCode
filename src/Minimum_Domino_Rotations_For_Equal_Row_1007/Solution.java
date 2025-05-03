package Minimum_Domino_Rotations_For_Equal_Row_1007;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
        System.out.println(minDominoRotations(new int[]{2, 2, 2, 3, 1, 1, 1, 1}, new int[]{2, 2, 2, 3, 1, 1, 1, 1}));
        System.out.println(minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
    }


    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int res = Math.min(check(tops, bottoms, tops[0]), check(tops, bottoms, bottoms[0]));
        if (res == n) return -1;
        return res;
    }


    private static int check(int[] tops, int[] bottoms, int targetValue) {
        int n = tops.length;

        int topCounter = 0;
        int botCounter = 0;

        for (int i = 0; i < n; i++) {
            boolean t = tops[i] == targetValue;
            boolean b = bottoms[i] == targetValue;
            if (t && b) {
                topCounter++;
                botCounter++;
            } else if (!t && !b) {
                return n;
            } else if (t) {
                topCounter++;
            } else {
                botCounter++;
            }
        }

        return Math.min(n - topCounter, n - botCounter);
    }
}
