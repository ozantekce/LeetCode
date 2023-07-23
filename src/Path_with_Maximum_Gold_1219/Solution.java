package Path_with_Maximum_Gold_1219;

import java.util.*;

public class Solution {


    public static void main(String[] args) {


        int grid [][] = new int[][]{{0,6,0},{5,8,7},{0,9,0}};
        int grid2 [][] = new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        int grid3 [][] = new int[][]{{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};

        //System.out.println(getMaximumGold(grid));
        //System.out.println(getMaximumGold(grid2));
        System.out.println(getMaximumGold(grid3));

    }

    private static int rowLimit;
    private static int colLimit;

    private static int maxValue = 0;

    public static int getMaximumGold(int[][] grid) {
        maxValue = 0;

        rowLimit = grid.length;
        colLimit = grid[0].length;

        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                if (grid[i][j] != 0) {
                    findRecursive(i, j, grid, 0);
                }
            }
        }

        return maxValue;
    }


    public static void findRecursive(int row, int col, int[][] grid, int value) {

        int gold = grid[row][col];
        value += gold;
        grid[row][col] = 0;

        int newRow;
        int newCol;

        newRow = row+1;
        if (newRow < rowLimit && grid[newRow][col] != 0) {
            findRecursive(newRow, col, grid, value);
        }

        newRow = row - 1;
        if (newRow >= 0 && grid[newRow][col] != 0) {
            findRecursive(newRow, col, grid, value);
        }

        newCol = col + 1;
        if (newCol < colLimit && grid[row][newCol] != 0) {
            findRecursive(row, newCol, grid, value);
        }

        newCol = col - 1;
        if (newCol >= 0 && grid[row][newCol] != 0) {
            findRecursive(row, newCol, grid, value);
        }

        grid[row][col] = gold;

        if (value > maxValue) {
            maxValue = value;
        }
    }


}
