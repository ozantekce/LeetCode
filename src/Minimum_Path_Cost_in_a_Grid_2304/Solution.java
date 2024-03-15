package Minimum_Path_Cost_in_a_Grid_2304;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        System.out.println(minPathCost(new int[][]{{5,3},{4,0},{2,1}}
                ,new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}}));

    }


    public static int minPathCost(int[][] grid, int[][] moveCost) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] DP = new int[m][n];

        DP[0] = grid[0];

        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                DP[r][c] = grid[r][c] + moveCost[grid[r-1][0]][c] + DP[r-1][0];
                for (int i = 1; i < n; i++) {
                    int cost = cost(r-1, i, r, c, grid, moveCost) + DP[r-1][i];
                    DP[r][c] = Math.min(DP[r][c], cost);
                }
            }
        }

        int min = DP[m-1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, DP[m-1][i]);
        }

        return min;
    }


    private static int cost(int r0,int c0, int r1, int c1, int[][] grid, int[][] moveCost){
        return moveCost[grid[r0][c0]][c1] + grid[r1][c1];
    }


}
