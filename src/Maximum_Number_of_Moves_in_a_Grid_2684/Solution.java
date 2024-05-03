package Maximum_Number_of_Moves_in_a_Grid_2684;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxMovesDP(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}}));

    }




    private static int [][] Moves = new int[][]{{-1,1},{0,1},{1,1}};
    private static int [][] Memory;
    public static int maxMoves(int[][] grid) {

        int res = 0;
        Memory = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            res = Math.max(res, recursive(grid, i, 0));
        }
        return res;
    }

    private static int recursive(int[][] grid, int row, int col){

        if(Memory[row][col] != 0)
            return Memory[row][col];

        int currentVal = grid[row][col];
        int maxMoves = 0;
        for (int[] move : Moves) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                int nextVal = grid[nextRow][nextCol];
                if (nextVal > currentVal) {
                    int moves = 1 + recursive(grid, nextRow, nextCol);
                    maxMoves = Math.max(maxMoves, moves);
                }
            }
        }

        Memory[row][col] = maxMoves;
        return maxMoves;
    }



    public static int maxMovesDP(int [][] grid){

        int[][] dp = new int[grid.length][grid[0].length];
        int res = 0;

        for (int row = 0; row < grid.length; row++) {
            int currentVal = grid[row][0];
            for (int[] move : Moves) {
                int nextRow = row + move[0];
                int nextCol = move[1];
                if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                    int nextVal = grid[nextRow][nextCol];
                    if (nextVal > currentVal) {
                        int moves = 1 + dp[row][0];
                        int maxMoves = Math.max(moves, dp[nextRow][nextCol]);
                        dp[nextRow][nextCol] = maxMoves;
                        res = Math.max(maxMoves, res);
                    }
                }
            }

        }


        for (int col = 1; col < grid[0].length; col++) {
            boolean exit = true;
            for (int row = 0; row < grid.length; row++) {
                int currentVal = grid[row][col];

                for (int[] move : Moves) {
                    int nextRow = row + move[0];
                    int nextCol = col + move[1];
                    if (dp[row][col] != 0 && nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length) {
                        int nextVal = grid[nextRow][nextCol];
                        if (nextVal > currentVal) {
                            exit = false;
                            int moves = 1 + dp[row][col];
                            int maxMoves = Math.max(moves, dp[nextRow][nextCol]);
                            dp[nextRow][nextCol] = maxMoves;
                            res = Math.max(maxMoves, res);
                        }
                    }
                }

            }
            if (exit)
                break;
        }

        return res;
    }



}
