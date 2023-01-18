package Convert_1D_Array_Into_2D_Array_2022;

public class Solution {


    public static void main(String[] args) {

        int [] original = new int[]{1,2};

        construct2DArray(original,1,1);

    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length)
            return new int[][]{};
        int array [][] = new int[m][n];

        int x = 0,y = 0;

        for (int i = 0; i < original.length; i++) {

            array[x][y] = original[i];

            y++;
            if(y==n){
                x++;
                y=0;
            }
        }
        return array;
    }

}
