package Sort_the_Matrix_Diagonally_1329;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int[][] array = {{11,25,66,1,69,7},{23,55,17,45,15,52},{75,31,36,44,58,8},{22,27,33,25,68,4},{84,28,14,11,5,50}};

        array = diagonalSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        
    }


    public static int[][] diagonalSort(int[][] mat) {


        List<Integer> currentValues = new ArrayList<>();

        for (int l = 0; l < mat[0].length; l++) {
            currentValues.clear();
            for (int i = 0,j=l; i < mat.length && j<mat[0].length; i++,j++) {
                currentValues.add(mat[i][j]);
            }
            Collections.sort(currentValues);
            for (int i = 0,j=l,k=0; i < mat.length && j<mat[0].length; i++,j++,k++) {
                mat[i][j] = currentValues.get(k);
            }
        }

        for (int l = 1; l < mat.length; l++) {
            currentValues.clear();
            for (int i = l,j=0; i < mat.length && j<mat[0].length; i++,j++) {
                currentValues.add(mat[i][j]);
            }
            Collections.sort(currentValues);
            for (int i = l,j=0,k=0; i < mat.length && j<mat[0].length; i++,j++,k++) {
                mat[i][j] = currentValues.get(k);
            }
        }




        return mat;
    }


}
