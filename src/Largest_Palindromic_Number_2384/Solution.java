package Largest_Palindromic_Number_2384;

public class Solution {

    public static void main(String[] args) {


        System.out.println(largestPalindromic("00009"));

    }


    public static String largestPalindromic(String num) {

        char [] digitCounter = new char[58];
        char [] pairCounter = new char[58];

        char [] chars = num.toCharArray();

        boolean allZero = true;
        boolean allPairsZero = true;
        for (int i = 0; i < chars.length; i++) {
            digitCounter[chars[i]]++;
            if(allZero&&chars[i]!=48){
                allZero = false;
            }
            if(digitCounter[chars[i]]>=2){
                if(allPairsZero&&chars[i]!=48){
                    allPairsZero = false;
                }
                digitCounter[chars[i]]-=2;
                pairCounter[chars[i]]++;
            }
        }

        if(allZero){
            return "0";
        }else if(allPairsZero){
            pairCounter[48] = 0;
        }


        StringBuilder str1 = new StringBuilder();
        for (char i = (char) (pairCounter.length-1); i >=48 ; i--) {
            while (pairCounter[i]>0){
                str1.append((i));
                pairCounter[i]--;
            }
        }
        char digit = 0;
        for (char i = (char) (digitCounter.length-1); i >=48 ; i--) {
            if(digitCounter[i]>=1){
                digit = i;
                break;
            }
        }
        if(digit!=0){
            return str1.toString()+digit+str1.reverse().toString();
        }else{
            return str1.toString()+str1.reverse().toString();
        }

    }


}
