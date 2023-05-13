package Largest_Local_Values_in_a_Matrix_2373;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int [][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        int [][] result = largestLocal(grid);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        int [][] grid2 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};

        result = largestLocal(grid2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }


    }

    public static int[][] largestLocal(int[][] grid) {

        int n = grid.length;
        int m = n-2;
        int [][] matrix = new int[m][m];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < m; j++) {
                matrix[i][j] = findMax(grid,i,j);
            }
            
        }

        return matrix;
    }


    static int findMax(int [][] grid, int x,int y){

        int max = 0;

        for (int i = x; i < x+3; i++) {

            for (int j = y; j < y+3; j++) {
                max = Math.max(grid[i][j],max);
            }

        }

        return max;
    }

}
