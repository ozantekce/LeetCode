package Largest_Odd_Number_in_String_1903;

public class Solution {


    public static void main(String[] args) {

        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
        System.out.println(largestOddNumber("552"));
    }

    public static String largestOddNumber(String num) {

        for (int i = num.length()-1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if(n % 2 == 1){
                return num.substring(0, i+1);
            }

        }

        return "";
    }


}
