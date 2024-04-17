package Spiral_Matrix_54;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int [][] matrix = new int[][] {
                {10,20,30,40,50},
                {60,70,80,90,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};

        System.out.println(spiralOrder(matrix));

    }


    public static List<Integer> spiralOrder(int[][] matrix) {

        int dir = 0;
        int n = matrix.length * matrix[0].length;

        List<Integer> res = new ArrayList<>(n);

        int i = 0;
        int j = 0;
        int startI = 0;
        int endI = matrix.length - 1;

        int startJ = 0;
        int endJ = matrix[0].length - 1;

        for (int k = 0; k < n; k++) {
            
            if(dir == 0){
                res.add(matrix[i][j]);
                j++;
                if(j > endJ){
                    i++;
                    j--;
                    dir = 1;
                    startI++;
                }
            }
            else if(dir == 1){
                res.add(matrix[i][j]);
                i++;
                if(i > endI){
                    i--;
                    j--;
                    dir = 2;
                    endJ--;
                }
            }
            else if(dir == 2){
                res.add(matrix[i][j]);
                j--;
                if(j < startJ){
                    i--;
                    j++;
                    dir = 3;
                    endI--;
                }
            }
            else if(dir == 3){
                res.add(matrix[i][j]);
                i--;
                if(i < startI){
                    i++;
                    j++;
                    dir = 0;
                    startJ++;
                }
            }
        }



        return res;
    }

}
