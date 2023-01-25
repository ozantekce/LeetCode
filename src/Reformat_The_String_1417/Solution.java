package Reformat_The_String_1417;

public class Solution {


    public static void main(String[] args) {

        System.out.println(reformat("covid2019"));

    }




    public static String reformat(String s) {

        char [] sChars = s.toCharArray();

        char [] chars = new char[sChars.length];

        int counterNum = 0;
        int counterLet = 0;
        for (int i = 0; i < sChars.length ; i++) {
            char c = sChars[i];
            if(c>=48 && c<=57){
                counterNum++;
            }else if(c>=97 && c<=122){
                counterLet++;
            }
        }

        int numIndex = 0;
        int letIndex = 1;

        if(counterLet>counterNum){
            numIndex = 1;
            letIndex = 0;
        }

        for (int i = 0; i < sChars.length; i++) {

            char c = sChars[i];

            if(c>=48 && c<=57){
                if(numIndex>=sChars.length){
                    return "";
                }
                chars[numIndex] = c;
                numIndex+=2;

            }else if(c>=97 && c<=122){
                if(letIndex>=sChars.length){
                    return "";
                }
                chars[letIndex] = c;
                letIndex+=2;

            }

        }


        return new String(chars);
    }


}
