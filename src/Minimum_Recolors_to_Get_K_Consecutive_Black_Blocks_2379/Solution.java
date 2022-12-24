package Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks_2379;

public class Solution {

    public static void main(String[] args) {


        System.out.println(minimumRecolors("BWWWBB",6));

    }


    public static int minimumRecolors(String blocks, int k) {
        
        char [] chars = blocks.toCharArray();

        int min = Integer.MAX_VALUE;
        for (int i = k; i <= chars.length; i++) {

            int counter = 0;
            for (int j = i-k; j <i; j++) {

                if(chars[j]=='W'){
                    counter++;
                }
            }
            min = Math.min(counter,min);
        }

        return min;
    }


}
