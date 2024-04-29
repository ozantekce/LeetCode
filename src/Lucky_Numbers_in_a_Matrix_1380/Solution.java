package Lucky_Numbers_in_a_Matrix_1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}}));
        System.out.println(luckyNumbers(new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}}));
        System.out.println(luckyNumbers(new int[][]{{86563,85030},{22847,23081},{62933,45557}}));
    }


    public static List<Integer> luckyNumbers (int[][] matrix) {

        int [] minRows = new int[matrix.length];
        int [] maxCols = new int[matrix[0].length];

        Arrays.fill(minRows, Integer.MAX_VALUE);
        Arrays.fill(maxCols, Integer.MIN_VALUE);

        HashSet<Integer> temp = new HashSet<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                maxCols[col] = Math.max(maxCols[col], matrix[row][col]);
                minRows[row] = Math.min(minRows[row], matrix[row][col]);
            }
            temp.add(minRows[row]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < maxCols.length; i++) {
            if(!temp.add(maxCols[i])){
                res.add(maxCols[i]);
            }
        }

        return res;
    }

}
