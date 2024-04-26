package Minimum_Falling_Path_Sum_II_1289;


public class Solution {


    public static void main(String[] args) {


        System.out.println(minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //System.out.println(minFallingPathSum(new int[][]{{7}}));

    }


    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] minValues = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int[] minIndices = {-1, -1};

        for (int i = 0; i < n; i++) {
            updateMinValuesAndIndices(grid[0][i], i, minValues, minIndices);
        }

        for (int row = 1; row < n; row++) {
            int[] currentMinValues = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] currentMinIndices = {-1, -1};

            for (int col = 0; col < n; col++) {
                int val = grid[row][col] + (col != minIndices[0] ? minValues[0] : minValues[1]);
                updateMinValuesAndIndices(val, col, currentMinValues, currentMinIndices);
            }

            minValues = currentMinValues;
            minIndices = currentMinIndices;
        }

        return minValues[0];
    }

    private static void updateMinValuesAndIndices(int val, int index, int[] minValues, int[] minIndices) {
        if (val < minValues[0]) {
            minValues[1] = minValues[0];
            minIndices[1] = minIndices[0];
            minValues[0] = val;
            minIndices[0] = index;
        } else if (val < minValues[1]) {
            minValues[1] = val;
            minIndices[1] = index;
        }
    }








    private static int [][] memory;
    public static int minFallingPathSumRecursive(int[][] grid) {

        memory = new int[grid.length][grid.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            min = Math.min(recursive(grid,0, i), min);
        }

        return min;
    }
    private static int recursive(int[][] grid, int row, int col){

        if(row == grid.length)
            return 0;
        else if(memory[row][col] != 0){
            return memory[row][col];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if(i == col)
                continue;
            int val = grid[row][col] + recursive(grid, row+1, i);
            min = Math.min(min, val);
        }
        min = min == Integer.MAX_VALUE ? grid[row][col] : min;
        memory[row][col] = min;
        return min;
    }

}
