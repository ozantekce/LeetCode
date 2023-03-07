package Greatest_English_Letter_in_Upper_and_Lower_Case_2309;

import java.util.Set;
import java.util.TreeSet;

public class Solution {


    public static void main(String[] args) {


        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));

    }

    public static String greatestLetter(String s) {

        boolean [] charsUpper = new boolean[26];
        boolean [] charsLower = new boolean[26];
        char [] chars = s.toCharArray();
        char result = 0;
        for (int i = 0; i < chars.length; i++) {

            if(chars[i]>=65 && chars[i]<=90){
                char c = chars[i];
                if(result>c)continue;
                int index = chars[i]-65;
                charsUpper[index] = true;
                if(charsLower[index]){
                    if(result<c)result = c;
                }
            }else{
                char cL = chars[i];
                char cU = (char) (cL-' ');
                if(result>cU)continue;
                int index = chars[i]-97;
                charsLower[index] = true;
                if(charsUpper[index]){
                    if(result<cU)result = cU;
                }
            }
        }
        if(result==0)
            return "";
        return result+"";

    }


}
