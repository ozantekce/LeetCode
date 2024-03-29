package Largest_Triangle_Area_812;

public class Solution {


    public static void main(String[] args) {

        //int points[][] = {{0,0},{0,1},{1,0},{0,2},{2,0}};

        //int points[][] = {{1,0},{0,0},{0,1}};

        System.out.println(largestTriangleArea(new int [][]{{8,10},{2,7},{9,2},{4,10}}));

    }

    public static double largestTriangleArea(int[][] points) {

        double max = 0;
        for (int i = 0; i < points.length-2; i++) {
            for (int j = i+1; j < points.length-1; j++) {
                for (int k = j+1; k < points.length; k++) {
                    max = Math.max(max, area(points[i], points[j], points[k]));
                }
            }
        }
        return max;
    }

    public static double area(int[] A, int[] B, int[] C) {
        int preResult = (A[0] * (B[1] - C[1]) +
                         B[0] * (C[1] - A[1]) +
                         C[0] * (A[1] - B[1]));
        if(preResult < 0){
            preResult *= -1;
        }
        return preResult * 0.5d;
    }

}
