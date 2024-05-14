package Largest_Substring_Between_Two_Equal_Characters_1624;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }



    public static int maxLengthBetweenEqualCharacters(String s) {

        int res = -1;
        int [] firstPos = new int[26];
        Arrays.fill(firstPos, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(firstPos[c] != -1){
                res = Math.max(i - firstPos[c] - 1 , res);
            }else{
                firstPos[c] = i;
            }
        }

        return res;
    }


}
