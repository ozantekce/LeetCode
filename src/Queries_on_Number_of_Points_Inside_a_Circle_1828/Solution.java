package Queries_on_Number_of_Points_Inside_a_Circle_1828;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] result = countPoints(points, queries);
        System.out.println(Arrays.toString(result));

    }

    public static int[] countPoints(int[][] points, int[][] queries) {

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int rSqr = queries[i][2];
            rSqr *= rSqr;
            int count = 0;
            for (int j = 0; j < points.length; j++) {

                if(distance(queries[i][0], queries[i][1], points[j][0], points[j][1])
                        <= rSqr){
                    count++;
                }

            }
            res[i] = count;

        }

        return res;
    }



    private static int distance(int x0, int y0, int x1, int y1){
        return ((x0-x1) * (x0-x1)) + ((y0-y1) * (y0-y1));
    }



}
