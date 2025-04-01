package Solving_Questions_With_Brainpower_2140;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));
        //System.out.println(mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));

    }


    public static long mostPoints(int[][] questions) {

        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int point = questions[i][0];
            int nextIndex = i + questions[i][1] + 1;
            long value0 = point + (nextIndex < n ? dp[nextIndex] : 0);
            long value1 = dp[i + 1];
            dp[i] = Math.max(value0, value1);
        }

        return dp[0];
    }

}
