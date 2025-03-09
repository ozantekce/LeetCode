package Find_Missing_and_Repeated_Values_2965;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})));
    }


    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long nSqr = n * n;
        long sum = (nSqr * (nSqr + 1)) / 2;
        long sumSqr = (nSqr * (nSqr + 1) * (2 * nSqr + 1)) / 6;
        long value = 0;
        long valueSqr = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                value += grid[i][j];
                valueSqr += (long) grid[i][j] * grid[i][j];
            }
        }

        long dif_a_b = sum - value;
        long sum_a_b = (sumSqr - valueSqr) / dif_a_b;

        long a = (dif_a_b + sum_a_b) / 2;
        long b = sum_a_b - a;

        return new int[]{(int) b, (int) a};
    }

}
