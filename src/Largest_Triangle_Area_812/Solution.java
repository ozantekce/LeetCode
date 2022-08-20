package Largest_Triangle_Area_812;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //int points[][] = {{0,0},{0,1},{1,0},{0,2},{2,0}};

        //int points[][] = {{1,0},{0,0},{0,1}};

        int points[][] = {{8,10},{2,7},{9,2},{4,10}};


        System.out.println(largestTriangleArea(points));

    }

    public static double largestTriangleArea(int[][] points) {

        double max = 0;
        for (int i = 0; i < points.length; i++) {

            for (int j = i+1; j < points.length; j++) {

                for (int k = j+1; k < points.length; k++) {
                    double current = area(points[i],points[j],points[k]);
                    if(current>max)
                        max=current;
                }

            }

        }
        return max;
    }

    public static float area(int[] A, int[] B, int[] C) {

        float area = (A[0] * (B[1] - C[1])
                + B[0] * (C[1] - A[1]) + C[0] * (A[1] - B[1])) / 2.0f;
        return Math.abs(area);
    }

}
