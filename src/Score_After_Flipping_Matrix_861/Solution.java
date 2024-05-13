package Score_After_Flipping_Matrix_861;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }


    public static int matrixScore(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // 0,2,4,8,..

        // maximize rows
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            if(row[0] != 1){
                for (int j = 0; j < m; j++) {
                    row[j] = row[j] == 0 ? 1 : 0;
                }
            }
        }
        
        //maximize cols
        for (int i = 0; i < m; i++) {
            int numberOfOnes = 0;
            int numberOfZeros = 0;
            for (int j = 0; j < n; j++) {
                if(grid[j][i] == 1){
                    numberOfOnes++;
                }else{
                    numberOfZeros++;
                }
            }
            
            if(numberOfZeros > numberOfOnes){
                for (int j = 0; j < n; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
            
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int val = 0;
            int mul = 1;
            for (int j = m-1; j >= 0; j--) {
                val += mul * grid[i][j];
                mul <<= 1;
            }
            total += val;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        
        
        return total;
    }


}
