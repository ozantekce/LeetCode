package Matrix_Diagonal_Sum_1572;

public class Solution {

    public static void main(String[] args) {

    }


    public static int diagonalSum(int[][] mat) {

        int n = mat.length;
        int res = 0;
        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            res += mat[i][j];
        }
        for (int i = 0, j = n-1; i < n && j >= 0; i++, j--) {
            res += mat[i][j];
        }

        if(n % 2 == 1){
            res -= mat[n/2][n/2];
        }

        return res;
    }

}
