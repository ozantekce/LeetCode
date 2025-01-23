package Count_Servers_that_Communicate_1267;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countServers(new int[][]{{1,0},{0,1}}));
        System.out.println(countServers(new int[][]{{1,0},{1,1}}));

    }



    public static int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];
                if(val == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];
                if(val == 1 && (rows[i] > 1 || cols[j] > 1)){
                    counter++;
                }
            }
        }

        return counter;
    }


}
