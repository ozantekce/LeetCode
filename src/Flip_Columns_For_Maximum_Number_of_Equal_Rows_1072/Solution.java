package Flip_Columns_For_Maximum_Number_of_Equal_Rows_1072;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
        System.out.println(maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 1}}));

    }


    public static int maxEqualRowsAfterFlips(int[][] matrix) {

        HashMap<String, Integer> counter = new HashMap<>();
        chars = new char[matrix[0].length];

        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            String key = getKeys(row);
            counter.put(key, counter.getOrDefault(key, 0) + 1);
            res = Math.max(res, counter.get(key));
        }

        return res;
    }


    private static char[] chars = new char[0];
    public static String getKeys(int[] row) {
        boolean opposite = row[0] == 1;
        if(opposite){
            for (int i = 0; i < row.length; i++) chars[i] = (char) (row[i]);
        }
        else{
            for (int i = 0; i < row.length; i++) chars[i] = (char) (row[i] ^ 1);
        }
        return new String(chars);
    }

}
