package Max_Increase_to_Keep_City_Skyline_807;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }


    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] rowsMax = new int[grid.length];
        int[] colsMax = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            rowsMax[i] = max;
        }

        for (int i = 0; i < grid.length; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            colsMax[i] = max;
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int val = Math.min(rowsMax[i], colsMax[j]);
                res += val - grid[i][j];
            }
        }

        return res;
    }

}
