package Palindrome_Number_9;

import java.util.ArrayList;

public class Solution {



    public static void main(String[] args) {

        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1000000001));


    }


    public static boolean isPalindrome(int x) {

        if(x<0)
            return false;
        // find size
        int size = 0;
        long mul = 1;
        while (true){
            if(mul>x){
                break;
            }
            size++;
            mul*=10;
        }
        mul/=10;
        for (int i = 0; i < size/2; i++) {
            if(x==0)
                return true;
            int v1 = (int) (x/mul);
            int v2 = x%10;

            if(v1!=v2)
                return false;
            x -= v1*mul;
            x/=10;
            mul/=100;
        }

        return true;
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
