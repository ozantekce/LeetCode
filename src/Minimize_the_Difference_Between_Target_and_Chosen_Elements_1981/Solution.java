package Minimize_the_Difference_Between_Target_and_Chosen_Elements_1981;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minimizeTheDifference(new int[][]{{1,2,3},{4,5,6},{7,8,9}},13));
        System.out.println(minimizeTheDifference(new int[][]{{1},{2},{3}},100));
        System.out.println(minimizeTheDifferenceDp(new int[][]{{1,2,9,8,7}},6));
        System.out.println(minimizeTheDifferenceDp(new int[][]{{1},{2},{3}},100));

        /*
        System.out.println(minimizeTheDifference(new int[][]
                {
                    {10,3,7,7,9,6,9,8,9,5},
                    {1,1,6,8,6,7,7,9,3,9},
                    {3,4,4,1,3,6,3,3,9,9},
                    {6,9,9,3,8,7,9,6,10,6},
                },5));
*/

        System.out.println(minimizeTheDifference(new int[][]{{15,15},{5,15},{2,15}},29));
    }


    private static int[][] Memory;
    private static int[] RowToMin;

    public static int minimizeTheDifference(int[][] mat, int target) {
        Memory = new int [mat.length][target+1];
        for (int i = 0; i < Memory.length; i++) {
            Arrays.fill(Memory[i], -1);
        }

        RowToMin = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < mat[0].length; j++) {
                min = Math.min(mat[i][j], min);
            }
            if(i != 0)
                RowToMin[i] = min + RowToMin[i-1];
            else
                RowToMin[i] = min;
        }

        return recursive(mat, 0, target);
    }

    private static int recursive(int[][] mat,int row, int target){

        int absTarget  = target;
        if(absTarget < 0)
            absTarget *= -1;

        if(row == mat.length){
            return absTarget;
        }

        if(target <= 0){
            int minAbsTarget = RowToMin[mat.length-1] - RowToMin[row-1] + absTarget;
            //Memory[row][target] = minAbsTarget;
            return minAbsTarget;
        }

        if(Memory[row][target] != -1)
            return Memory[row][target];

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < mat[0].length; i++) {
            int val = mat[row][i];
            int diff = recursive(mat,row + 1,target-val);
            minDiff = Math.min(minDiff, diff);
        }
        Memory[row][target] = minDiff;
        return minDiff;
    }

    public static int minimizeTheDifferenceDp(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int maxPossibleSum = 0;
        int currentMaxSum = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, mat[i][j]);
            }
            maxPossibleSum += max;
        }

        int[][] dp = new int[n][maxPossibleSum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0; j < m; j++) {
            dp[0][mat[0][j]] = Math.abs(target - mat[0][j]);
            currentMaxSum = Math.max(currentMaxSum, mat[0][j]);
        }

        for (int i = 1; i < n; i++) {
            int nextMaxSum = currentMaxSum;
            for (int j = 0; j <= currentMaxSum; j++) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    for (int k = 0; k < m; k++) {
                        int newSum = j + mat[i][k];
                        dp[i][newSum] = Math.min(dp[i][newSum], Math.abs(target - newSum));
                        nextMaxSum = Math.max(nextMaxSum, newSum);
                    }
                }
            }
            currentMaxSum = nextMaxSum;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= currentMaxSum; j++) {
            minDiff = Math.min(minDiff, dp[n - 1][j]);
        }

        return minDiff;
    }





}
