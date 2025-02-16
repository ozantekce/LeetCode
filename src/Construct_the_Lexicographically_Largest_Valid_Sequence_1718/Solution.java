package Construct_the_Lexicographically_Largest_Valid_Sequence_1718;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(Arrays.toString(constructDistancedSequence(3)));
        System.out.println(Arrays.toString(constructDistancedSequence(5)));

    }


    public static int[] constructDistancedSequence(int n) {
        boolean[] used = new boolean[n + 1];
        int[] res = new int[2 * n - 1];
        find(used, 0, res, n);
        return res;
    }

    private static boolean find(boolean[] used, int i, int[] res, int range) {
        if (i == res.length) return true;
        if (res[i] != 0) return find(used, i + 1, res, range);

        for (int num = range; num > 1; num--) {
            if (used[num]) continue;
            int j = i + num;
            if (j >= res.length || res[j] != 0) continue;

            res[i] = num;
            res[j] = num;

            used[num] = true;
            if (find(used, i + 1, res, range)) return true;
            used[num] = false;

            res[i] = 0;
            res[j] = 0;
        }

        if (used[1]) return false;
        res[i] = 1;
        used[1] = true;
        if (find(used, i + 1, res, range)) return true;
        used[1] = false;
        res[i] = 0;

        return false;
    }

}
