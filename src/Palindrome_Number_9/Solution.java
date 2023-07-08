package Palindrome_Number_9;

import java.util.ArrayList;

public class Solution {



    public static void main(String[] args) {

        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1000000001));

        //  121 | 0
        //  12  | 1
        //  1   | 12
    }


    public static boolean isPalindrome(int x) {

        if(x<0)
            return false;
        int reversed = 0;
        int temp = x;
        while (temp>0){
            reversed*=10;
            reversed += temp%10;
            temp/=10;
        }
        return reversed == x;
    }


    public static boolean isPalindrome2(int x) {

        if(x<0)
            return false;
        int temp = x;
        int val =0;
        while (true){
            val += temp%10;
            temp/=10;
            if(temp==0)
                break;
            val*=10;
        }
        return x == val;
    }


    public static boolean isPalindrome3(int x) {

        if(x<0)
            return false;

        char [] val = Integer.toString(x).toCharArray();

        int first=0,last=val.length-1;
        while (true){

            if(first>=last){
                break;
            }
            if(val[first]!= val[last]){
                return false;
            }

            first++;
            last--;

        }
        return true;
    }

}
