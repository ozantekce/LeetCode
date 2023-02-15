package Diagonal_Traverse_498;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));

    }

    public static int[] findDiagonalOrder(int[][] mat) {


        int i=0,ci;
        int j=0,cj;

        boolean dir = true; // true->up | false->down

        int index = 0;

        int result [] = new int[mat.length*mat[0].length];

        while (index<result.length){

            if(dir){
                ci = -1;
                cj = +1;
            }else{
                ci = +1;
                cj = -1;
            }

            while (i>=0 && i<mat.length && j>=0 && j<mat[0].length){
                result[index] = mat[i][j];
                //System.out.println(index+" "+result[index]);
                index++;
                i+=ci;
                j+=cj;
            }

            i-=ci;
            j-=cj;

            if(dir){
                j++;
                if(j>=mat[0].length){
                    i+=1;
                    j-=1;
                }
            }else{
                i++;
                if(i>=mat.length){
                    i-=1;
                    j+=1;
                }
            }

            dir=!dir;

        }


        return result;
    }

}
