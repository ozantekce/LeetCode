package Reshape_the_Matrix_566;

import java.util.Arrays;

public class Solution {



    public static void main(String[] args) {

        int mat[][] = {{1,2},{3,4}};

        mat = matrixReshape(mat,4,1);

        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }

    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        if(mat.length*mat[0].length!=r*c)
            return mat;

        int [][] matrix = new int[r][c];

        int c0 = mat[0].length;
        for (int i = 0; i < r*c; i++) {
            matrix[i/c][i%c] = mat[i/c0][i%c0];
        }
        return matrix;
    }


}
