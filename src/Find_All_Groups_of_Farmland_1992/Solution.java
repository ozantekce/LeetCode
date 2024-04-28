package Find_All_Groups_of_Farmland_1992;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,0,0}, {0,1,1}, {0,1,1}})));
        //System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1}, {1,1}})));
        //System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1}, {0,0}})));
        System.out.println(Arrays.deepToString(findFarmland(new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1}})));

    }


    public static int[][] findFarmland(int[][] land) {

        List<int[]> list = new ArrayList<>();

        int n = land.length;
        int m = land[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(land[i][j] == 0)
                    continue;

                int right = j;
                int r_j = j;
                while (true){
                    if(r_j >= m || land[i][r_j] == 0){
                        break;
                    }else{
                        right = r_j;
                        r_j++;
                    }
                }

                int down = i;
                int d_i = i;
                while (true){
                    if(d_i >= n || land[d_i][right] == 0){
                        break;
                    }else{
                        down = d_i;
                        d_i++;
                    }
                }

                for (int k = i; k <= down; k++) {
                    for (int l = j; l <= right; l++) {
                        land[k][l] = 0;
                    }
                }

                list.add(new int[]{i,j,down,right});
            }
        }
        return list.toArray(new int[list.size()][]);
    }


}
