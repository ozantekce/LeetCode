package Minimum_Falling_Path_Sum_II_1289;

public class Solution {


    public static void main(String[] args) {


        System.out.println(minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(minFallingPathSum(new int[][]{{7}}));

    }

    private static int [][] memory;
    public static int minFallingPathSum(int[][] grid) {

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
