package Delete_Operation_for_Two_Strings_583;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minDistance("bd","abcd"));

    }


    public static int minDistance(String word1, String word2) {

        char [] chars1 = word1.toCharArray();
        char [] chars2 = word2.toCharArray();

        int [][] DP = new int[chars1.length+1][chars2.length+1];

        for (int i = 1; i < chars1.length+1; i++) {

            for (int j = 1; j < chars2.length+1; j++) {

                if(chars1[i-1]==chars2[j-1]){
                    DP[i][j] = 1+ DP[i-1][j-1];
                }else{
                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
                }

            }

        }

        return chars1.length+chars2.length-2*DP[chars1.length][chars2.length];
    }

    public static int minDistanceRecursive(String word1, String word2) {

        char [] chars1 = word1.toCharArray();
        char [] chars2 = word2.toCharArray();

        memory = new int[chars1.length][chars2.length];

        int rec = recursive(chars1,chars2,0,0);

        return chars1.length+chars2.length-2*rec;
    }



    private static int [][] memory;
    public static int recursive(char[] chars1, char[] chars2,int i1,int i2){

        if(i1>=chars1.length||i2>=chars2.length){
            return 0;
        }
        if(memory[i1][i2]!=0){
            return memory[i1][i2];
        }
        if(chars1[i1]==chars2[i2]){
            return memory[i1][i2] = 1+ recursive(chars1,chars2,i1+1,i2+1);
        }else{
            return memory[i1][i2] = Math.max(recursive(chars1,chars2,i1+1,i2),recursive(chars1,chars2,i1,i2+1));
        }

    }

}
