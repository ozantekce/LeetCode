package Count_Pairs_Of_Similar_Strings_2506;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {


        System.out.println(similarPairs(new String[]{"aaabbcc","abcdefghijklmnopqrstuvwxyz"}));
        
    }



    public static int similarPairs(String[] words) {

        // We can create 67.108.864 different binary values.
        // We can convert this binary values to integer values.
        // For example :
        // zzz -> [0,0,0...,0,1] and it's int value 1
        // zyzy -> [0,0,0...,1,1] and it's int value 3

        int [] intValues = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int [] binary = convertBinary(words[i].toCharArray());
            System.out.println(Arrays.toString(binary));
            int key = convertInt(binary);
            System.out.println(key);
            intValues[i] = key;
        }


        // We are finding all possible pairs
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            int key1 = intValues[i];
            for (int j = i+1; j < words.length; j++) {
                int key2 = intValues[j];
                if(key1==key2){
                    counter++;
                }
            }
        }

        return counter;
    }


    private static int[] binary = new int[26];
    public static int[] convertBinary(char [] chars){

        //reset
        for (int i = 0; i < 26; i++) binary[i] = 0;

        //set
        for (int i = 0; i < chars.length; i++) binary[chars[i]-97] = 1;

        return binary;
    }


    public static int convertInt(int[] b){

        int i=0;
        int mul = 1;
        for (int j = 25; j >=0 ; j--) {
            i += b[j] * mul;
            mul*=2;
        }
        return i;

    }


}
