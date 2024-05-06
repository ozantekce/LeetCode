package Special_Positions_in_a_Binary_Matrix_1582;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

    }


    public static int numSpecial(int[][] mat) {

        int [] rows = new int[mat.length];
        int [] cols = new int[mat[0].length];
        int res = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {
                int val = mat[i][j];
                if(val == 1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {
                int val = mat[i][j];
                if(val == 1 && rows[i] == 1 && cols[j] == 1){
                    res++;
                }
            }
        }

        return res;
    }



}
