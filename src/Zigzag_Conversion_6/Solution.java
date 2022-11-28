package Zigzag_Conversion_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(convert("ABCDEF",5));

    }



    public static String convert(String s, int numRows) {

        int l = s.length();
        int n = 2*(numRows-1);
        if(numRows==1)
            n=1;
        System.out.println(l);
        System.out.println(n);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i+=n) {
            stringBuilder.append(s.charAt(i));
        }
        System.out.println(stringBuilder.toString());

        int increase1,increase2;
        increase2 = 2;
        increase1 = n-increase2;

        for (int i = 1; i < numRows-1; i++) {

            boolean even = true;
            for (int j = i; j < s.length(); ) {
                if(even&&increase1!=0){
                    stringBuilder.append(s.charAt(j));
                }
                if(!even&&increase2!=0){
                    stringBuilder.append(s.charAt(j));
                }

                if(even){
                    j+=increase1;
                    even=false;
                }else{
                    j+=increase2;
                    even=true;
                }
                System.out.println(j);
            }
            System.out.println(stringBuilder.toString());
            increase2 +=2;
            increase1 = n-increase2;
        }

        if(n>1)
        for (int i = numRows-1; i < s.length(); i+=n) {
            stringBuilder.append(s.charAt(i));
        }
        System.out.println(stringBuilder.toString());


        return stringBuilder.toString();
    }

    /*
    public static String convert(String s, int numRows) {

        char[][] array = new char[numRows][s.length()];

        int j = 0;
        int counter = 0;

        upperWhile:
        while (counter<s.length()){
            for (int i = 0; i < numRows; i++) {
                if(counter>=s.length())
                    break upperWhile;
                //System.out.println("i:"+i+" j: "+j +" c: "+counter);
                array[i][j] = s.charAt(counter);
                counter++;
            }
            int i = numRows-2;
            j++;
            while (i>0){
                if(counter>=s.length())
                    break upperWhile;
                //System.out.println("i:"+i+" j: "+j +" c: "+counter);
                array[i][j] = s.charAt(counter);
                i--;
                j++;
                counter++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int control = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k <array[i].length; k++) {
                if(array[i][k]!=0){
                    stringBuilder.append(array[i][k]);
                    control++;
                    if(control>=s.length())
                        break;
                }
            }
        }

        return stringBuilder.toString();
    }
*/
}
