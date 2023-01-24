package Rotate_Image_48;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {


        int [][] matrix ={{1,2,3},{4,5,6},{7,8,9}};

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }



    public static void rotate(int[][] matrix) {

        for (int i = 0; i < (matrix.length+1)/2; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-j-1][i];
                matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
                matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
                matrix[j][matrix.length-i-1] = temp;
            }
        }
    }


}
