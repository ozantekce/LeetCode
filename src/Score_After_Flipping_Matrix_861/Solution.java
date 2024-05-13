package Score_After_Flipping_Matrix_861;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
        System.out.println(matrixScore(new int[][]{{0,1},{1,1}}));

    }


    public static int matrixScore(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean [] rowFlips = new boolean[n];
        boolean [] colFlips = new boolean[m];
        // 0,2,4,8,..

        // maximize rows
        for (int i = 0; i < n; i++) {
            rowFlips[i] = grid[i][0] != 1;
        }

        //maximize cols
        for (int col = 0; col < m; col++) {
            int numberOfOnes = 0;
            for (int row = 0; row < n; row++) {
                if(grid[row][col] == (rowFlips[row] ? 0 : 1)){
                    numberOfOnes++;
                }
            }
            if(n > 2 * numberOfOnes){
                colFlips[col] = true;
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = 0; j < m; j++) {
                int num = grid[i][j];
                if(rowFlips[i] ^ colFlips[j]){
                    num = num == 0 ? 1 : 0;
                }
                val <<= 1;
                val += num;
            }
            total += val;
        }

        return total;
    }


}
