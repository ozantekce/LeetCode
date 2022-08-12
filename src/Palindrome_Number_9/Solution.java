package Palindrome_Number_9;

public class Solution {



    public static void main(String[] args) {

        System.out.println(isPalindrome(-121));



    }



    public static boolean isPalindrome(int x) {

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

}
