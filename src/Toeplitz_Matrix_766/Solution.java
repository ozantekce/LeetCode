package Toeplitz_Matrix_766;

public class Solution {



    public static void main(String[] args) {

        System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
        System.out.println(isToeplitzMatrix(new int[][]{{1,2},{2,2}}));

    }



    public static boolean isToeplitzMatrix(int[][] matrix) {


        int [] row = matrix[0];
        int [] check = new int[row.length];
        buildCheck(check, row);
        for (int i = 1; i < matrix.length; i++) {
            row = matrix[i];
            if(!checkRow(check,row)) return false;
            buildCheck(check, row);
        }


        return true;
    }

    public static boolean checkRow(int[] check, int[] row){
        for (int i = 1; i < row.length; i++) {
            if(check[i] != row[i]) return false;
        }
        return true;
    }

    private static void buildCheck(int[] check, int[] row){

        for (int i = 0; i < row.length-1; i++) {
            check[i+1] = row[i];
        }

    }


}
