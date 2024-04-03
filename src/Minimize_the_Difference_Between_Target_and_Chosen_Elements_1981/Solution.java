package Minimize_the_Difference_Between_Target_and_Chosen_Elements_1981;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minimizeTheDifference(new int[][]{{1,2,3},{4,5,6},{7,8,9}},13));
        System.out.println(minimizeTheDifference(new int[][]{{1},{2},{3}},100));
        System.out.println(minimizeTheDifference(new int[][]
                {
                    {10,3,7,7,9,6,9,8,9,5},
                    {1,1,6,8,6,7,7,9,3,9},
                    {3,4,4,1,3,6,3,3,9,9},
                    {6,9,9,3,8,7,9,6,10,6},
                },5));

    }


    private static HashMap<Integer,Integer>[] Memory;
    private static int[] RowToMin;

    public static int minimizeTheDifference(int[][] mat, int target) {
        Memory = new HashMap[mat.length];
        for (int i = 0; i < Memory.length; i++) {
            Memory[i] = new HashMap<>();
        }

        RowToMin = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < mat[0].length; j++) {
                min = Math.min(mat[i][j], min);
            }
            if(i != 0)
                RowToMin[i] = min + RowToMin[i-1];
            else
                RowToMin[i] = min;
        }

        return recursive(mat, 0, target);
    }

    private static int recursive(int[][] mat,int row, int target){

        int absTarget  = target;
        if(absTarget < 0)
            absTarget *= -1;

        if(row == mat.length){
            return absTarget;
        }

        if(Memory[row].containsKey(target))
            return Memory[row].get(target);

        if(target <= 0){
            int minAbsTarget = RowToMin[mat.length-1] - RowToMin[row-1] + absTarget;
            Memory[row].put(target, minAbsTarget);
            return minAbsTarget;
        }



        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < mat[0].length; i++) {
            int val = mat[row][i];
            int diff = recursive(mat,row + 1,target-val);
            minDiff = Math.min(minDiff, diff);
        }
        Memory[row].put(target, minDiff);
        return minDiff;
    }


}
